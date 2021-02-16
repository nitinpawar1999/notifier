<Style>
.editNotebookModal{
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

.editNotebookModal .edit-notebook-page{
  width: 360px;
  padding: 4% 0 0;
  margin: auto;
}

.editNotebookModal .edit-notebook-page .form{
  position: relative;
    z-index: 1;
    background: #FFFFFF;
    max-width: 360px;
    margin: 0 auto 100px;
    padding: 45px;
    text-align: center;
    box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  
}

.editNotebookModal .edit-notebook-page .form .editnotebookClose {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
  margin-top: -40px;
  margin-right: -25px;
}

.editNotebookModal .edit-notebook-page .form .editnotebookClose:hover,
.editNotebookModal .edit-notebook-page .form .editnotebookClose:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

.editNotebookModal .edit-notebook-page .form input {
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

.editNotebookModal .edit-notebook-page .form input[type="submit"] {
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
</Style>
<!-- Edit Notebook Modal -->
<div id="editNotebookModal" class="editNotebookModal">
<!-- Edit Notebook Modal content -->
<div class="edit-notebook-page">

    <div class="form">
      <label>Edit NOTEBOOK</label>
      <span id="editnotebookClose" class="editnotebookClose" onclick="javascript:window.history.back(-1);return false;" >&times;</span>
      <br><br>
      <form action="<%=request.getContextPath()%>/editNotebook" method="post">
        <label>Notebook Name</label>
        <input type="hidden" id="editnotebookid" value="<%=request.getParameter("notebookId")%>" name="notebookId">
        <br><br>
        <input type="text" name="notebookName" placeholder="Notebook Name" required />
        <br><br>
        <input type="submit" value="Submit" />
      </form>
    </div>
  </div>

</div>
<!----------------------------------------------------------------------------------------->
<script>
    window.onclick = function(event) {
  if (event.target == editNotebookModal) {
    window.history.back(-1);return false;
  }

}
  </script>
