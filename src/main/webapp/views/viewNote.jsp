<%@ page import="hibernate.model.Note" %>
<style>

.noteViewModal{
  display: block;
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


.noteViewModal .note-view-page{
  width: 80%;
  height: 70%;
  padding: 4% 0 0;
  margin: auto;
}
.noteViewModal .note-view-page .noteDetails{
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 80%;
  margin: 0 auto 100px;
  margin-top: 60px;
  padding: 45px;
  height: 70%;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);

}

.noteViewModal .note-view-page .noteDetails > h2{
  margin-top: auto;
}

.noteViewModal .note-view-page .noteDetails >label{
  font-size: large;
  float: left;
  font-weight: bold;
  margin-left: 10px;
}

.noteViewModal .note-view-page .noteDetails .noteViewClose{
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
  margin-top: -80px;
  margin-right: -25px;
}



.noteViewModal .note-view-page .noteDetails .noteViewClose:hover,
.noteViewModal .note-view-page .noteDetails .noteViewClose:focus{
color: black;
  text-decoration: none;
  cursor: pointer;
}


</style>
<!-------Note View Modal---------------------->
<div id="noteViewModal" class="noteViewModal">

    <!-- Note View Modal content -->
    <div class="note-view-page">

      <div class="noteDetails">
        <h2>Note Details</h2>
        <span id="noteViewClose" class="noteViewClose" onclick="javascript:window.history.back(-1);return false;">&times;</span>
        <br><br>
          <label>Note Name:  </label>
          <label><%=request.getParameter("noteName")%></label>
          <br>
          <hr>
          <label>StarDate:  </label>
          <label><%=request.getParameter("startDate")%></label>
          <br>
          <hr>
          <label>EndDate:  </label>
          <label><%=request.getParameter("endDate")%></label>
          <br>
          <hr>
          <label>ReminderDate:  </label>
          <label><%=request.getParameter("reminderDate")%></label>
          <br>
          <hr>
          <label>Status:  </label>
          <label><%=request.getParameter("status")%></label>
          <br>
          <hr>
          <label>Tag:  </label>
          <label><%=request.getParameter("tag")%></label>
          <br>
          <hr>
          <label>Notebook Name:  </label>
          <label><%=request.getParameter("notebookName")%></label>
          <br>
          <hr>
          <label>Description:  </label>
          <label><%=request.getParameter("description")%></label>
      </div>
    </div>
  </div>
  <!----------------------------------------------------------------->

  <script>
    window.onclick = function(event) {
  if (event.target == noteViewModal) {
    window.history.back(-1);return false;
  }

}
  </script>

