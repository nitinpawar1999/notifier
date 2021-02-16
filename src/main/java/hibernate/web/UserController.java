package hibernate.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.dao.UserDao;
import hibernate.model.User;
import hibernate.model.Notebook;
import hibernate.util.HibernateUtil;

@WebServlet("/register")
public class UserController extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private UserDao userDao;
public void init(){
    userDao = new UserDao();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    register(request, response);
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.sendRedirect("register.jsp");
}

private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String userName = request.getParameter("userName");
    String mobNumber = request.getParameter("mobNumber");
    String emailAddress = request.getParameter("emailAddress");
    String password = request.getParameter("password");

    User user = new User();
    List<Notebook> notebooks = new ArrayList<>();
    user.setUserName(userName);
    user.setMobNumber(mobNumber);
    user.setEmailAddress(emailAddress);
    user.setPassword(password);
    user.setNotebooks(notebooks);
    
    if(validateEmail(emailAddress)){
        request.setAttribute("error", "Email already Exist!");
        request.getRequestDispatcher("views/register.jsp").forward(request, response);
    }
    else if(validateMobile(mobNumber)){
        request.setAttribute("error", "Mobile Number already Exist!");
        request.getRequestDispatcher("views/register.jsp").forward(request, response);
    }
    else{
    userDao.saveUser(user);
    RequestDispatcher dispatcher = request.getRequestDispatcher("views/register_success.jsp");
    dispatcher.forward(request, response);
    }
}

public boolean validateEmail(String emailAddress){
    Transaction transaction = null;
    User user = null;
    boolean flag = false;
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        
        transaction = session.beginTransaction();

        user = (User) session.createQuery("FROM User U WHERE U.emailAddress = :emailAddress")
                             .setParameter("emailAddress", emailAddress).uniqueResult();
                             
        
        if(user != null)
        flag = true;
        transaction.commit();
    }catch (Exception e){
       if(transaction != null){
           transaction.rollback();
       }
       e.printStackTrace(); 
    }finally{
        session.close();
    }
    return flag;
}

public boolean validateMobile(String mobNumber){
    Transaction transaction = null;
    User user = null;
    boolean flag = false;
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        
        transaction = session.beginTransaction();

        user = (User) session.createQuery("FROM User U WHERE U.mobNumber = :mobNumber")
                             .setParameter("mobNumber", mobNumber).uniqueResult();
                             
        
        if(user != null)
        flag = true;
        transaction.commit();
    }catch (Exception e){
       if(transaction != null){
           transaction.rollback();
       }
       e.printStackTrace(); 
    }finally{
        session.close();
    }
    return flag;
}

}
