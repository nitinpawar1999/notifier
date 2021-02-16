package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Notebook;
import hibernate.model.User;
import hibernate.util.HibernateUtil;

public class NotebookDao {

    public void saveNotebook(Notebook notebook, int id){
        Transaction transaction = null;
        Session session = null;
        User user;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            user = (User) session.get(User.class, id);
            notebook.setUser(user);

            session.save(notebook);

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
    
    public void deleteNotebook(int id){
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Notebook notebook = session.get(Notebook.class, id);
            if(notebook != null){
                session.delete(notebook);
                System.out.println("Notebook Deleted");
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
    }

	public void editNotebook(String notebookName, int id) {
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Notebook notebook = session.get(Notebook.class, id);
            notebook.setNotebookName(notebookName);
            if(notebook != null){
                session.update(notebook);
                
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
	}
}
