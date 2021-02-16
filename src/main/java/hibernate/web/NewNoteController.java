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

@WebServlet("/newNote")
public class NewNoteController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    NoteDao noteDao = null;
    public void init() {
        noteDao = new NoteDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        addNote(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("dashboard.jsp");
    }

    private void addNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String noteName = request.getParameter("noteName");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        Date reminderDate = Date.valueOf(request.getParameter("reminderDate"));
        String status = request.getParameter("status");
        String tag = request.getParameter("tag");
        int notebookId = Integer.parseInt(request.getParameter("notebookId"));
        String description = request.getParameter("description");
        int userId = (int)request.getSession().getAttribute("userId");
        

        Note note = new Note();
        note.setName(noteName);
        note.setStartDate(startDate);
        note.setEndDate(endDate);
        note.setReminderDate(reminderDate);
        note.setStatus(status);
        note.setTag(tag);
        note.setDescription(description);

        noteDao.saveNote(note, userId, notebookId);
        request.setAttribute("viewType", "note");
        request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
        

    }
}
