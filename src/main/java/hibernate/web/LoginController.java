package hibernate.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.UserDao;
import hibernate.model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;
    
    public void init(){
        loginDao = new UserDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            autheticate(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void autheticate(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String emailAddress = req.getParameter("emailAddress");
        String password = req.getParameter("password");

        User user = loginDao.validate(emailAddress, password);
        if(user != null){
            req.setAttribute("viewType", "note");
            req.getSession().setAttribute("userId", user.getId());
            req.getSession().setAttribute("userName", user.getUserName());
            req.getSession().setAttribute("userEmail", user.getEmailAddress());
            req.getSession().setAttribute("userNumber", user.getMobNumber());
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/dashboard.jsp");
            dispatcher.forward(req, resp);
        }else{
            req.setAttribute("error", "Wrong Email or Password!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/login.jsp");
            dispatcher.forward(req, resp);
            throw new Exception("Login not successful..");
        }
    }
    
}
