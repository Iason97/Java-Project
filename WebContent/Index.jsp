<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Arxikh selida</title>
<link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>
<img src="background.jpg"  width="460" height="345" >
<%
if(request.getParameter("parametros").equals("students")){ %>

	<h1 style="color:blue;" align="center">Hello  Student, <%=request.getParameter("name") %>!</h1>
			<div align="center">
			<form method="post" class="verical-menu" action="StudentServlet">	 
			<input type="radio" name="student_param" value="student1">Provoli vathmologias ana mathima 
			<br>
			<input type="radio" name="student_param" value="student2">Provolh vathmologias ana eksamhno
			<br>
			<input type="radio" name="student_param" value="student3">Provolh synolikhs vathmologias(gia ola ta mathimata pou exei parei)
			<br>
			<input type="submit" class="btn" value="Fygame!">
			</form>
			</div>
<%
}
%>
<%if(request.getParameter("parametros").equals("secretaries")){%>
	<h1 style="color:blue;" align="center">Hello  Secretarian, <%=request.getParameter("name") %>!</h1>
			<div class="vertical-menu" align="center">
			  <a href="SecretaryServlet?param=mathimata"  ><h4>Provoli synolou mathimatwn</h4></a><br>
			  <a href="SecretaryServlet?param=mathimata2" ><h4>Provoli mathimatwn kai kathgiti ana mathima</h4></a><br> 
			  <a href="SecretaryServlet?param=professor" ><h4>Anathesi mathimatos se kathigiti.</h4></a><br> 
			</div>
<%
}
%>
<% if(request.getParameter("parametros").equals("professors")){%>

	   <h1 style="color:blue;" align="center">Hello  Professor, <%=request.getParameter("name") %>!</h1>
			<div  align="center">
			<form method="post" class="verical-menu" action="ProfessorServlet">	 
			<input type="radio" name="professor_param" value="professor1">Provoli listas vathmologias ana mathima 
			<br>
			<input type="radio" name="professor_param" value="professor2">Kataxwrhsh vathmologias ana mathima<br>
			<input type="submit" class="btn" value="Fygame!">
			</form>
			</div>
<%
}
%>
</body>
</html>