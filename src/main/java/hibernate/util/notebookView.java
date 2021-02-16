package hibernate.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notebookView")
public class notebookView extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("viewType", "notebook");
        req.getRequestDispatcher("views/dashboard.jsp").forward(req, resp);
    }
    
}
