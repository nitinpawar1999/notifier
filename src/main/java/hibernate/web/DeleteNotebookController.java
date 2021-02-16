package hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.NotebookDao;

@WebServlet("/deleteNotebook")
public class DeleteNotebookController extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private NotebookDao notebookDao;

    public void init(){
        notebookDao = new NotebookDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        deleteNotebook(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("views/dashboard.jsp");
    }

    private void deleteNotebook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt((String)request.getParameter("notebookId"));
        notebookDao.deleteNotebook(id);
        request.setAttribute("viewType", "notebook");
        request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
    }
}
