package hibernate.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Note;
import hibernate.model.Notebook;
import hibernate.model.User;
import hibernate.util.HibernateUtil;

public class UserDao {
    User user=null;
    public void saveUser(User user){
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    public User validate(String emailAddress, String password){
        Transaction transaction = null;
        User user = null;
        Session session = null;
        Boolean flag = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();

            user = (User) session.createQuery("FROM User U WHERE U.emailAddress = :emailAddress")
                                 .setParameter("emailAddress", emailAddress).uniqueResult();
                                 
            if(user != null && user.getPassword().equals(password)){
                flag = true;
            }
            transaction.commit();
        }catch (Exception e){
           if(transaction != null){
               transaction.rollback();
           }
           e.printStackTrace(); 
        }finally{
            session.close();
        }
        if(flag)
        return user;
        else
        return null;
    }

    public boolean editUser(User edituser, int id){
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            user = (User) session.get(User.class, id);
            user.setUserName(edituser.getUserName());
            user.setEmailAddress(edituser.getEmailAddress());
            user.setMobNumber(edituser.getMobNumber());
            user.setPassword(edituser.getPassword());
            session.update(user);

            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return false;
    }

    public List<Notebook> getNotebookList(HttpServletRequest request){
        Transaction transaction = null;
        Session session = null;
        List<Notebook> list = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            user = (User) session.get(User.class, (int) request.getSession().getAttribute("userId"));
            list = user.getNotebooks();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return list;
    }


    public List<Note> getNoteList(HttpServletRequest request){
        Transaction transaction = null;
        Session session = null;
        List<Note> list = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            user = (User) session.get(User.class, (int) request.getSession().getAttribute("userId"));
            list = user.getNotes();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return list;
    }
    
}
