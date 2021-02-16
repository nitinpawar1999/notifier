package hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.dao.UserDao;
import hibernate.model.User;
import hibernate.util.HibernateUtil;

@WebServlet("/edituser")
public class EditUserController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        editUser(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("edituser.jsp");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String mobNumber = request.getParameter("mobNumber");
        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");

        User user = new User();
        user.setUserName(userName);
        user.setMobNumber(mobNumber);
        user.setEmailAddress(emailAddress);
        user.setPassword(password);

        if (validateEmail(emailAddress, request)) {
            System.out.println("email exists");
            request.setAttribute("updateStatus", emailAddress + " already Exist!");
            request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
        } else if (validateMobile(mobNumber, request)) {
            System.out.println("number exists");
            request.setAttribute("updateStatus", mobNumber+" already exists!");
            request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
        } else {
            if (userDao.editUser(user, (int) request.getSession().getAttribute("userId"))) {
                System.out.println("Edit User Successful!");
                request.setAttribute("updateStatus", "Edit User Successful!");
                request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
            }
            else{
                System.out.println("Edit User Unsuccessful!");
                request.setAttribute("updateStatus", "Edit User Unsuccessful!");
                request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
            }
        }

    }

    public boolean validateEmail(String emailAddress, HttpServletRequest req) {
        Transaction transaction = null;
        User user = null;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            user = (User) session.createQuery("FROM User U WHERE U.emailAddress = :emailAddress AND U.id != :id")
                    .setParameter("emailAddress", emailAddress)
                    .setParameter("id", req.getSession().getAttribute("userId")).uniqueResult();

            if (user != null)
                flag = true;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }

    public boolean validateMobile(String mobNumber, HttpServletRequest req) {
        Transaction transaction = null;
        User user = null;
        boolean flag = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            user = (User) session.createQuery("FROM User U WHERE U.mobNumber = :mobNumber  AND U.id != :id")
                    .setParameter("mobNumber", mobNumber).setParameter("id", req.getSession().getAttribute("userId"))
                    .uniqueResult();

            if (user != null)
                flag = true;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }
}
