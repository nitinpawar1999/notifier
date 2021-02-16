package hibernate.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.NoteDao;
import hibernate.model.Note;

@WebServlet("/editNote")
public class EditNoteController extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private NoteDao noteDao;

    public void init(){
        noteDao = new NoteDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editNote(request, response);        
    }

    private void editNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("noteId"));
        int notebookId = Integer.parseInt(request.getParameter("notebookId"));
        Note editnote = new Note();
        
        editnote.setName(request.getParameter("noteName"));
        editnote.setStartDate(Date.valueOf(request.getParameter("startDate")));
        editnote.setEndDate(Date.valueOf(request.getParameter("endDate")));
        editnote.setReminderDate(Date.valueOf(request.getParameter("reminderDate")));
        editnote.setStatus(request.getParameter("status"));
        editnote.setTag(request.getParameter("tag"));
        editnote.setDescription(request.getParameter("description"));

        noteDao.editNote(editnote, id, notebookId);
        request.setAttribute("viewType", "note");
        request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
    
    }
}
