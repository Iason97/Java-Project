<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>

<h1 style="text-align:center; color:blue;">Professor Assignment</h1>
<div style="text-align:center">

<form  class="vertical_menu" action="SecretaryServlet" method="POST">
  Id:<br>
  <input type="text" name="a1" value=${a1}>
   <br>
  Course_id:<br>
  <input type="text" name="a2" >
  <br>
  Professor_id:<br>
  <input type="text" name="a3" >
  <br><br>
  <input type="submit" class="btn" value="Submit" />
</form> 
</div>


</body>
</html>