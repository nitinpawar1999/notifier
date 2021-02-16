window.arr = new Array();
const body = document.body;
const collapseBtn = document.querySelector(".admin-menu .collapse-btn");
const toggleMobileMenu = document.querySelector(".toggle-mob-menu");
const collapsedClass = "collapsed";

collapseBtn.addEventListener("click", function() {
  this.getAttribute("aria-expanded") == "true"
    ? this.setAttribute("aria-expanded", "false")
    : this.setAttribute("aria-expanded", "true");
  this.getAttribute("aria-label") == "collapse menu"
    ? this.setAttribute("aria-label", "expand menu")
    : this.setAttribute("aria-label", "collapse menu");
  body.classList.toggle(collapsedClass);
});

toggleMobileMenu.addEventListener("click", function() {
  this.getAttribute("aria-expanded") == "true"
    ? this.setAttribute("aria-expanded", "false")
    : this.setAttribute("aria-expanded", "true");
  this.getAttribute("aria-label") == "open menu"
    ? this.setAttribute("aria-label", "close menu")
    : this.setAttribute("aria-label", "open menu");
  body.classList.toggle("mob-menu-opened");
});


// Get the modal
var userModal = document.getElementById("userModal");

// Get the button that opens the modal
var editbtn = document.getElementById("editUser");

// Get the <span> element that closes the modal
var editspan = document.getElementsByClassName("userClose")[0];



var notebookModal = document.getElementById("newNotebookModal");
var createNotebookBtn = document.getElementById("newNotebookBtn");
var notebookspan = document.getElementsByClassName("notebookClose")[0];

var noteModal = document.getElementById("newNoteModal");
var createNoteBtn = document.getElementById("newNoteBtn");
var notespan = document.getElementsByClassName("noteClose")[0];

var reminderModal = document.getElementById("reminderDropdown");
var badge = document.getElementById("badge");

badge.onclick = function(){
  reminderModal.style.display = "block";
}

createNotebookBtn.onclick = function(){

  notebookModal.style.display = "block"; 
}

notebookspan.onclick = function(){
  notebookModal.style.display = "none";
}

createNoteBtn.onclick = function(){
  noteModal.style.display = "block";
}

notespan.onclick = function(){
  noteModal.style.display = "none";
}



// When the user clicks on the button, open the modal
editbtn.onclick = function() {
  userModal.style.display = "block";
}


// When the user clicks on <span> (x), close the modal
editspan.onclick = function() {
  userModal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == userModal) {
    userModal.style.display = "none";
  }

  if(event.target == notebookModal){
    notebookModal.style.display = "none";
  }

  if(event.target == noteModal){
    noteModal.style.display = "none";
  }

  if(event.target == reminderModal){
    reminderModal.style.display = "none";
  }
}

var search = document.getElementById("searchbar");
var searchNote = document.getElementById("searchbarnote");

search.onkeyup = function(){
  let input = document.getElementById("searchbar").value;
  input=input.toLowerCase();
  let x = document.getElementsByClassName("noteName");
  let y = document.getElementsByClassName("notebookCards");
  for( var i =0;i<x.length;i++){
    if(!x[i].innerHTML.toLowerCase().includes(input)){
      y[i].style.display = "none";
    }
    else{
      y[i].style.display = "block";
    }
  }
}

searchNote.onkeyup = function(){
  let input = document.getElementById("searchbarnote").value;
  input=input.toLowerCase();
  let x = document.getElementsByClassName("noteName");
  let z = document.getElementsByClassName("searchDesciption");
  let y = document.getElementsByClassName("noteCards");
  for( var i =0;i<x.length;i++){
    if(!(x[i].innerHTML.toLowerCase().includes(input))){
      y[i].style.display = "none";
    }
    else{
      y[i].style.display = "block";
    }
  }
}
