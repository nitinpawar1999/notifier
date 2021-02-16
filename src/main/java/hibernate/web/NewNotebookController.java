package hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.NotebookDao;
import hibernate.model.Notebook;

@WebServlet("/newNotebook")
public class NewNotebookController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private NotebookDao notebookDao;

    public void init() {
        notebookDao = new NotebookDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addNotebook(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("dashboard.jsp");
    }

    private void addNotebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String notebookName = request.getParameter("notebookName");



        Notebook notebook = new Notebook();
        notebook.setNotebookName(notebookName);

        notebookDao.saveNotebook(notebook, (int)request.getSession().getAttribute("userId"));
        
        request.setAttribute("viewType", "notebook");
        request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
        

    }
}
