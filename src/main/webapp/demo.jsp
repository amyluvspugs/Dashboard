function loadDoc() {
   var xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function() {
     if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML = this.responseText;
     }
   };
   xhttp.open("GET", "ajax_info.txt", true);
   xhttp.open("GET", "updateTaskServlet.java?id='id'", true);
   xhttp.send();

   xhttp.open("POST", "/updateTaskServlet", true);
   xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   xhttp.send("fname=Henry&lname=Ford");
 }