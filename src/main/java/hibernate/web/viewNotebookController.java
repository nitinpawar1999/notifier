package hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewNotebook")
public class viewNotebookController extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("viewType", "note");
        request.setAttribute("viewnotebookId", request.getParameter("notebookId"));
        request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
    }
    
}
