package hibernate.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.NoteDao;

@WebServlet("/deleteNote")
public class DeleteNoteController extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private NoteDao noteDao;
    public void init(){
        noteDao = new NoteDao();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteNote(request, response);
    }

    private void deleteNote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt((String) request.getParameter("noteId"));
        
        noteDao.deleteNote(id);
        request.setAttribute("viewType", "note");
        request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);

    }
}
