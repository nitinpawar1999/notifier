<%@ page import="java.util.List,hibernate.model.Notebook,hibernate.model.Note,hibernate.dao.UserDao" %>
  <% UserDao userDao=null; List<Notebook> notebookList = null;%>
<style>
    .newNoteModal{
  display: "block";
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */

}

.newNoteModal .new-note-page{
  width: 950px;
  padding: 4% 0 0;
  margin: auto;
}

.newNoteModal .new-note-page .form{
  position: relative;
    z-index: 1;
    background: #FFFFFF;
    max-width: 950px;
    margin: 0 auto 100px;
    padding: 45px;
    text-align: center;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.newNoteModal .new-note-page .form .noteClose{
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
  margin-top: -40px;
  margin-right: -25px;
}

.newNoteModal .new-note-page .form .noteClose:hover,
.newNoteModal .new-note-page .form .noteClose:focus{
color: black;
  text-decoration: none;
  cursor: pointer;
}

.newNoteModal .new-note-page .form label{
  padding: auto;
  float: left;
  font-size: large;
}


.newNoteModal .new-note-page .form input{
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.newNoteModal .new-note-page .form .dateEntry{
  display: flex;
}

.newNoteModal .new-note-page .form .dateEntry > div label {
  padding: auto;
  font-size: large;
}
.newNoteModal .new-note-page .form .dateEntry > div input[type="Date"]{
  width: 61%;
  height: 5%;
}

.newNoteModal .new-note-page .form select{
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.newNoteModal .new-note-page .form .description{
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  height: 16%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.newNoteModal .new-note-page .form input[type="submit"] {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #242e42;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  transition-duration: 0.4s;
  cursor: pointer;
}
</style>


<!-- New Note Modal -->
<div id="newNoteModal" class="newNoteModal">

    <!-- New Note Modal content -->
    <div class="new-note-page">

      <div class="form">
        <h2>EDIT NOTE</h2>
        <span id="noteClose" class="noteClose" onclick="javascript:window.history.back(-1);return false;">&times;</span>
        <br><br>
        <form action="<%=request.getContextPath()%>/editNote" method="post">
          <label>Note Name</label>
          <br>
          <input type="text" name="noteName" placeholder="<%=request.getParameter("noteName")%>" required />
          <br>
          <div id="dateEntry" class="dateEntry">
            <div>
              <label>StartDate</label>
              <input type="date" id="startDate" name="startDate" required>
            </div>

            <div>
              <label>EndDate</label>
              <input type="date" id="endDate" name="endDate" required>
            </div>

            <div>
              <label>ReminderDate</label>
              <input type="date" id="reminderDate" name="reminderDate" required>
            </div>

          </div>


          <label>Status</label>
          <select id="status" name="status" required>
            <option value="Started">Started</option>
            <option value="In Progress">In Progess</option>
            <option value="Completed">Completed</option>
          </select>
          <br>
          <label>Tag</label>
          <select id="tag" name="tag" required>
            <option value="Private">Private</option>
            <option value="Public">Public</option>
          </select>
          <br>
          <label>Notebook Name (If No Selection Available Create a Notebook)</label>
          <select id="notebookId" name="notebookId" required>
            <% userDao=new UserDao(); notebookList=userDao.getNotebookList(request); if(notebookList !=null){ %>
              <%for(Notebook notebook: notebookList){%>
                <option value="<%=notebook.getId()%>">
                  <%=notebook.getNotebookName()%>
                </option>
                <%}} notebookList=null;%>
          </select>
          <br>
          <label>Description</label>
          <textarea name="description" id="description" class="description" placeholder="<%=request.getParameter("description")%>"
            required></textarea>
          <br>
          <input type="hidden" name="noteId" value="<%=request.getParameter("noteId")%>">
          <input type="submit" value="Submit" />
        </form>
      </div>
    </div>

  </div>
  <!-------------------------------------------------------------------------------------------->
  <script>
    window.onclick = function(event) {
  if (event.target == newNoteModal) {
    window.history.back(-1);return false;
  }

}
  </script>
