<%@ page import="java.sql.Date,java.util.List,hibernate.model.Notebook,hibernate.model.Note,hibernate.dao.UserDao" %>
  <% UserDao userDao=null; List<Notebook> notebookList = null;
    List<Note> noteList = null; 
      int reminderCount=0;
      long millis = System.currentTimeMillis();
      Date date = new Date(millis);
      %>
      <!--Meta Data with all icons-->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" type="text/css" href="views/css/dash.css">
      <svg style="display:none;">
        <symbol id="notification" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
          y="0px" width="22px" height="22px" viewBox="0 0 120.641 122.878" enable-background="new 0 0 120.641 122.878"
          xml:space="preserve">
          <g>
            <path fill-rule="evenodd" clip-rule="evenodd"
              d="M68.16,6.889c18.129,3.653,31.889,19.757,31.889,38.921 c0,22.594-2.146,39.585,20.592,54.716c-40.277,0-80.366,0-120.641,0C22.8,85.353,20.647,68.036,20.647,45.81 c0-19.267,13.91-35.439,32.182-38.979C53.883-2.309,67.174-2.265,68.16,6.889L68.16,6.889z M76.711,109.19 c-1.398,7.785-8.205,13.688-16.392,13.688c-8.187,0-14.992-5.902-16.393-13.688H76.711L76.711,109.19z" />
          </g>
        </symbol>
        <symbol id="down" viewBox="0 0 16 16">
          <polygon points="3.81 4.38 8 8.57 12.19 4.38 13.71 5.91 8 11.62 2.29 5.91 3.81 4.38" />
        </symbol>
        <symbol id="users" viewBox="0 0 16 16">
          <path
            d="M8,0a8,8,0,1,0,8,8A8,8,0,0,0,8,0ZM8,15a7,7,0,0,1-5.19-2.32,2.71,2.71,0,0,1,1.7-1,13.11,13.11,0,0,0,1.29-.28,2.32,2.32,0,0,0,.94-.34,1.17,1.17,0,0,0-.27-.7h0A3.61,3.61,0,0,1,5.15,7.49,3.18,3.18,0,0,1,8,4.07a3.18,3.18,0,0,1,2.86,3.42,3.6,3.6,0,0,1-1.32,2.88h0a1.13,1.13,0,0,0-.27.69,2.68,2.68,0,0,0,.93.31,10.81,10.81,0,0,0,1.28.23,2.63,2.63,0,0,1,1.78,1A7,7,0,0,1,8,15Z" />
        </symbol>
        <symbol id="comments" viewBox="0 0 16 16">
          <path d="M0,16.13V2H15V13H5.24ZM1,3V14.37L5,12h9V3Z" />
          <rect x="3" y="5" width="9" height="1" />
          <rect x="3" y="7" width="7" height="1" />
          <rect x="3" y="9" width="5" height="1" />
        </symbol>
        <symbol id="pages" viewBox="0 0 16 16">
          <rect x="4" width="12" height="12" transform="translate(20 12) rotate(-180)" />
          <polygon points="2 14 2 2 0 2 0 14 0 16 2 16 14 16 14 14 2 14" />
        </symbol>
        <symbol id="collapse" viewBox="0 0 16 16">
          <polygon points="11.62 3.81 7.43 8 11.62 12.19 10.09 13.71 4.38 8 10.09 2.29 11.62 3.81" />
        </symbol>
        <symbol id="search" viewBox="0 0 16 16">
          <path
            d="M6.57,1A5.57,5.57,0,1,1,1,6.57,5.57,5.57,0,0,1,6.57,1m0-1a6.57,6.57,0,1,0,6.57,6.57A6.57,6.57,0,0,0,6.57,0Z" />
          <rect x="11.84" y="9.87" width="2" height="5.93" transform="translate(-5.32 12.84) rotate(-45)" />
        </symbol>
      </svg>
      <!------------------------------------------------------------------------------->



      <!--Navigation Side Bar -->
      <header class="page-header">
        <nav>
          <label class="logo">RemindMe</label>
          <button class="toggle-mob-menu" aria-expanded="false" aria-label="open menu">
            <svg width="20" height="20" aria-hidden="true">
              <use xlink:href="#down"></use>
            </svg>
          </button>
          <ul class="admin-menu">
            <li class="menu-heading">
              <h3>Hi <%=session.getAttribute("userName")%>
              </h3>
            </li>
            <li>
              <form action="<%=request.getContextPath()%>/notebookView" method="post">
                <button type="submit" id="notebooks">
                  <svg>
                    <use xlink:href="#pages"></use>
                  </svg>
                  <span>NoteBooks</span>
                </button>
              </form>
            </li>


            <li>
              <form action="<%=request.getContextPath()%>/noteView" method="post">
                <button id="notes">
                  <svg>
                    <use xlink:href="#comments"></use>
                  </svg>
                  <span>Notes</span>
                </button>
              </form>
            </li>
            <li>
              <button id="editUser">
                <svg>
                  <use xlink:href="#users"></use>
                </svg>
                <span>Edit User</span>
              </button>
            </li>

            <li class="menu-heading">
              <h3>Your daily Tasks!!!%>
              </h3>
            </li>
            <% userDao = new UserDao();  noteList = userDao.getNoteList(request);
            
            for(Note note:noteList){
            if(note.getReminderDate().toString().equals(date.toString())){
              reminderCount++;  
            %>
            <li class="reminderItems">
              <form action="views/viewNote.jsp" method="post">
                <input type="hidden" name="noteName" value="<%=note.getName()%>">
                <input type="hidden" name="startDate" value="<%=note.getStartDate()%>">
                <input type="hidden" name="endDate" value="<%=note.getEndDate()%>">
                <input type="hidden" name="reminderDate" value="<%=note.getReminderDate()%>">
                <input type="hidden" name="status" value="<%=note.getStatus()%>">
                <input type="hidden" name="tag" value="<%=note.getTag()%>">
                <input type="hidden" name="notebookName" value="<%=note.getNotebook().getNotebookName()%>">
                <input type="hidden" name="description" value="<%=note.getDescription()%>">
                <button id="noteView" name="note"><%=note.getName()%></button>
              </form>
              <p>Start Date: <%=note.getStartDate()%></p>
              <p>End Date: <%=note.getStartDate()%></p>
              
            </li>
            <%}}noteList=null;%>

            <% if(reminderCount == 0){%>
              <p style="margin-left: 10px;">No Reminders</p>
            <%}%>
            <li>
              <button class="collapse-btn" aria-expanded="true" aria-label="collapse menu">
                <svg aria-hidden="true">
                  <use xlink:href="#collapse"></use>
                </svg>
                <span>Collapse</span>
              </button>
            </li>
          </ul>
        </nav>
      </header>
      <!------------------------------------------------------------------------------------------>


      <!-- The Edit User Modal -->
      <div id="userModal" class="usermodal">

        <!-- Edit User Modal content -->
        <div class="login-page">
          <div class="form">
            <span id="userClose" class="userClose">&times;</span>
            <form action="<%=request.getContextPath()%>/edituser" method="post">
              <label>Edit User</label>
              <input type="text" name="userName" placeholder="User Name" required />
              <input type="number" name="mobNumber" placeholder="Mobile Number" required />
              <input type="text" name="emailAddress" placeholder="Email Address" required />
              <input type="password" name="password" placeholder="Password" id="password" minlength="8" required=""
                oninvalid="this.setCustomValidity('Please Enter Valid Password Minimum Length - 8')"
                oninput="setCustomValidity('')" />
              <input type="password" name="conPass" placeholder="Confirm Password" id="confirm_password" required />
              <input type="submit" value="Save" />
            </form>

          </div>
        </div>

      </div>

      <% if(request.getAttribute("updateStatus") !=null){ %>
        <script>alert('${updateStatus}')</script>
        <%}%>


          <script>
            var password = document.getElementById("password")
              , confirm_password = document.getElementById("confirm_password");

            function validatePassword() {
              if (password.value != confirm_password.value) {
                confirm_password.setCustomValidity("Passwords Don't Match");
              } else {
                confirm_password.setCustomValidity('');
              }
            }

            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;
          </script>

          <!------------------------------------------------------------------------------------------------->

          <!-- New Notebook Modal -->
          <div id="newNotebookModal" class="newNotebookModal">

            <!-- New Notebook Modal content -->
            <div class="new-notebook-page">

              <div class="form">
                <label>ADD NEW NOTEBOOK</label>
                <span id="notebookClose" class="notebookClose">&times;</span>
                <br><br>
                <form action="<%=request.getContextPath()%>/newNotebook" method="post">
                  <label>Notebook Name</label>
                  <br><br>
                  <input type="text" name="notebookName" placeholder="Notebook Name" required />
                  <br><br>
                  <input type="submit" value="Submit" />
                </form>
              </div>
            </div>

          </div>
          <!-------------------------------------------------------------------------------------------->

          <!------------------------------------------------------------------------------------------------->

          <!-- New Note Modal -->
          <div id="newNoteModal" class="newNoteModal">

            <!-- New Note Modal content -->
            <div class="new-note-page">

              <div class="form">
                <h2>ADD NEW NOTE</h2>
                <span id="noteClose" class="noteClose">&times;</span>
                <br><br>
                <form action="<%=request.getContextPath()%>/newNote" method="post">
                  <label>Note Name</label>
                  <br>
                  <input type="text" name="noteName" placeholder="Note Name" required />
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
                  <textarea name="description" id="description" class="description" placeholder="Write Notes..."
                    required></textarea>
                  <br>
                  <input type="submit" value="Submit" />
                </form>
              </div>
            </div>

          </div>
          <!-------------------------------------------------------------------------------------------->




          <section class="page-content">

            <section class="header">
              <label class="headLabel" id="headLabel">Notes</label>


              <div class="search_bar">
                  <input id="searchbar" class="searchbar" type="text" name="search" placeholder="Search Notebooks..">
                  <input id="searchbarnote" class="searchbarnote" type="text" name="search" placeholder="Search Notes..">
                </div>

              <div id="newNotebook" class="newNotebook">
                <button id="newNotebookBtn" type="button" class="newNotebookBtn">Add New Notebook
                </button>
              </div>
              <div id="newNote" class="newNote">
                <button id="newNoteBtn" type="button" class="newNoteBtn">Add New Note
                </button>
              </div>

              <div class="admin-profile">
                <span class="greeting">Hi <%=session.getAttribute("userName")%></span>

                <div id="badge" class="notifications">
                  <span  class="badge"><%=reminderCount%></span>
                  <svg>
                    <use xlink:href="#notification"></use>
                  </svg>
                </div>
              </div>
              <div class="logout_div">
                <form action="<%=request.getContextPath()%>/logout" method="POST">
                <button type="submit" class="logout_btn">Log out
                </form>
                </button>
              </div>
            </section>

        <div id="reminderDropdown" class="reminderDropdown">
          <div class="dropdown-content">
            <h3>Reminder</h3>
            <% userDao = new UserDao();  noteList = userDao.getNoteList(request);
            for(Note note:noteList){
            if(note.getReminderDate().toString().equals(date.toString())){ 
            %>
            <div id="myDropdown" class="form">
                <form action="views/viewNote.jsp" method="post">
                  <input type="hidden" name="noteName" value="<%=note.getName()%>">
                  <input type="hidden" name="startDate" value="<%=note.getStartDate()%>">
                  <input type="hidden" name="endDate" value="<%=note.getEndDate()%>">
                  <input type="hidden" name="reminderDate" value="<%=note.getReminderDate()%>">
                  <input type="hidden" name="status" value="<%=note.getStatus()%>">
                  <input type="hidden" name="tag" value="<%=note.getTag()%>">
                  <input type="hidden" name="notebookName" value="<%=note.getNotebook().getNotebookName()%>">
                  <input type="hidden" name="description" value="<%=note.getDescription()%>">
                  <button id="noteView" name="note">NoteName : <%=note.getName()%></button>
                </form>
                <p>Start Date: <%=note.getStartDate()%></p>
                <hr>
              </div>
          <%}}noteList=null;%>
        </div>
        </div>

            <section class="grid">

              <% if(request.getAttribute("viewType")!=null){ String temp=(String)request.getAttribute("viewType");
                if(temp.equals("notebook")){ userDao=new UserDao(); notebookList=userDao.getNotebookList(request);
                if(notebookList !=null){%>
                <%for(Notebook notebook: notebookList){%>
                  <article class="notebookCards">
                    <div class="details">
                      <form action="<%=request.getContextPath()%>/viewNotebook" method="GET">
                      <button type="submit" style="font-size: x-large; color: #242e42;outline: none;" class="noteName" name="notebookId"
                      value="<%=notebook.getId()%>"><%=notebook.getNotebookName()%></button>
                      </form>
                      <br>
                      <p>Notes : <%=notebook.getNotes().size()%>
                      </p>
                    </div>

                    <div class="btns">

                      <form action="views/editNotebook.jsp" method="post">
                        <button type="submit" class="editnotebookBtn" name="notebookId"
                          value="<%=notebook.getId()%>">Edit</button>
                      </form>


                      <form action="<%=request.getContextPath()%>/deleteNotebook" method="post">
                        <button type="submit" name="notebookId" value="<%=notebook.getId()%>"
                          class="notebookDeleteBtn">&times; Delete</button>
                      </form>
                    </div>
                  </article>
                  <%}} notebookList=null; }}%>



                    <!------------------Note Cards-------------------->

                    <% if(request.getAttribute("viewType")!=null){ 
                      String tempnote=(String)request.getAttribute("viewType");
                      if(tempnote.equals("note")){ 
                        userDao=new UserDao(); 
                        noteList=userDao.getNoteList(request);
                        if(noteList != null){
                          if(request.getAttribute("viewnotebookId") != null){  
                            int id = Integer.parseInt((String)request.getAttribute("viewnotebookId"));  
                            for(int i=0;i<noteList.size();i++){
                              if(noteList.get(i).getNotebook().getId() != id) {
                                noteList.remove(i);
                              }
                              }
                            }
                                
                        for(Note note: noteList){%>
                        <article class="noteCards">
                          <div class="details">
                            <h2 class="noteName">
                              <%=note.getName()%>
                            </h2>
                            <h2 class="searchDescription" hidden>"<%=note.getDescription()%>"</h2>
                            <p>
                              Started On: <%=note.getStartDate()%>
                            </p>
                            <form action="views/viewNote.jsp" method="post">
                              <input type="hidden" name="noteName" value="<%=note.getName()%>">
                              <input type="hidden" name="startDate" value="<%=note.getStartDate()%>">
                              <input type="hidden" name="endDate" value="<%=note.getEndDate()%>">
                              <input type="hidden" name="reminderDate" value="<%=note.getReminderDate()%>">
                              <input type="hidden" name="status" value="<%=note.getStatus()%>">
                              <input type="hidden" name="tag" value="<%=note.getTag()%>">
                              <input type="hidden" name="notebookName" value="<%=note.getNotebook().getNotebookName()%>">
                              <input type="hidden" name="description" value="<%=note.getDescription()%>">
                              <button id="noteView" name="note">+</button>
                            </form>
                            

                          </div>

                          <div class="statusBtn">
                          <button class="status">
                            <%=note.getStatus()%>
                          </button>
                          </div>
                          <div class="btns">

                            <form action="views/editNote.jsp" method="post">
                              <input type="hidden" name="noteName" value="<%=note.getName()%>">
                              <input type="hidden" name="startDate" value="<%=note.getStartDate()%>">
                              <input type="hidden" name="endDate" value="<%=note.getEndDate()%>">
                              <input type="hidden" name="reminderDate" value="<%=note.getReminderDate()%>">
                              <input type="hidden" name="status" value="<%=note.getStatus()%>">
                              <input type="hidden" name="tag" value="<%=note.getTag()%>">
                              <input type="hidden" name="notebookName" value="<%=note.getNotebook().getNotebookName()%>">
                              <input type="hidden" name="description" value="<%=note.getDescription()%>">
                              <button type="submit" class="editnoteBtn" name="noteId"
                                value="<%=note.getId()%>">Edit</button>
                            </form>


                            <form action="<%=request.getContextPath()%>/deleteNote" method="post">
                              <button type="submit" name="noteId" value="<%=note.getId()%>"
                                class="noteDeleteBtn">&times; Delete</button>
                            </form>
                          </div>
                        </article>
                        <%}} request.setAttribute("viewnotebookId", null);noteList=null; }}%>
            </section>
          </section>



          <% if(request.getAttribute("viewType")!=null){ String temp=(String)request.getAttribute("viewType");
            if(temp.equals("notebook")){ %>
            <script>
              document.getElementById("headLabel").innerHTML = 'Notebooks';
              document.getElementById("newNotebook").style.display = "block";
              document.getElementById("newNote").style.display = "none";
              document.getElementById("searchbar").style.display = "block";
              document.getElementById("searchbarnote").style.display = "none";
            </script>
            <%}}%>

              <% if(request.getAttribute("viewType")!=null){ String temp=(String)request.getAttribute("viewType");
                if(temp.equals("note")){ %>
                <script>
                  document.getElementById("headLabel").innerHTML = 'Notes';
                  document.getElementById("newNotebook").style.display = "none";
                  document.getElementById("newNote").style.display = "block";
                  document.getElementById("searchbar").style.display = "none";
                 document.getElementById("searchbarnote").style.display = "block";
                </script>
                <%}}%>

                  <script src="views/script/dash.js"></script>