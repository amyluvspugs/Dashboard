$(document).ready(function(){
function updateArchive(Integer) {
   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
     if (this.readyState == 4 && this.status == 200) {
      document.getElementById("task.id").innerHTML = this.responseText;
     }
   };


   xhttp.open("POST", "/updateTaskServlet", true);
   xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   xhttp.send("fname=Henry&lname=Ford");
 }

 $(document).ready(function(){
 	$('#btnSubmit').click(function(event) {
 		var username=$('#txtName').val();
 		$.get('UpdateTaskServlet',{task:archive},function(responseText) {
 			$('#welcometext').text(responseText);
 		});
 	});
 });