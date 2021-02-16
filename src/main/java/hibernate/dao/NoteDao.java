package hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.model.Note;
import hibernate.model.Notebook;
import hibernate.model.User;
import hibernate.util.HibernateUtil;

public class NoteDao {
    public void saveNote(Note note,int userId ,int notebookId){
        Transaction transaction = null;
        Session session = null;
        Notebook notebook = null;
        User user = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            user = (User) session.get(User.class, userId);
            notebook = (Notebook) session.get(Notebook.class, notebookId);
            
            note.setUser(user);
            note.setNotebook(notebook);

            session.save(note);

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

    public void deleteNote(int id){
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Note note = session.get(Note.class, id);
            if(note != null){
                note.getNotebook().getNotes().remove(note);
                session.delete(note);
                System.out.println("Note Deleted");
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

	public void editNote(Note editnote, int id, int notebookId) {
        Transaction transaction = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Note note = session.get(Note.class, id);
            Notebook notebook = session.get(Notebook.class, notebookId);
            note.setName(editnote.getName());
            note.setStartDate(editnote.getStartDate());
            note.setEndDate(editnote.getEndDate());
            note.setReminderDate(editnote.getReminderDate());
            note.setStatus(editnote.getStatus());
            note.setTag(editnote.getTag());
            note.setNotebook(notebook);
            note.setDescription(editnote.getDescription());

            if(note != null){
                session.update(note);
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
