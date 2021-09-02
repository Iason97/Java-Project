<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
if(request.getParameter("kathgitis").equals("epilogh_mathimatos")){ 
	out.println("<div>\r\n" + 
			"			<form method=\"post\" action=\"ProfessorServlet\">	\r\n" + 
			"			<input type=\"text\" name=\"mathima_updt\" value=\"\">Mathima gia kataxwrhsh vathmologias\r\n" + 
			"			<input type=\"hidden\" name=\"professor_param\" value=\"professor2\" >\r\n" + 
			"			<input type=\"hidden\" name=\"flag\" value=\"yes\" >\r\n" + 
			"			<br>\r\n" + 
			"			<input type=\"submit\">\r\n" + 
			"			</form>\r\n" + 
			"			</div>");
}else if(request.getParameter("kathgitis").equals("vathmoi")){
	out.println("<h1 style=\"color:blue;\" align=\"center\">Hello  "+request.getParameter("name")+"</h1>\r\n" + 
			"<div class=\"vertical-menu\" align=\"center\">\r\n" + 
			"  <a href=\"SecretaryServlet?param=mathimata\"  ><h4>Provoli synolou mathimatwn</h4></a><br>\r\n" + 
			"  <a href=\"SecretaryServlet?param=mathimata2\" ><h4>Provoli mathimatwn kai kathgiti ana mathima</h4></a><br>\r\n" + 
			"  <a href=\"SecretaryServlet?param=professor\" ><h4>Anathesi mathimatos se kathigiti.</h4></a><br>\r\n" + 
			"</div>");
}else if(request.getParameter("parametros").equals("professors")){
	out.println("<div>\r\n"+
			"<form method=\"post\" class=\"verical-menu\" action=\"ProfessorServlet\">	\r\n" + 
			"<input type=\"radio\" name=\"professor_param\" value=\"professor1\">Provoli listas vathmologias ana mathima\r\n" + 
			"<br>\r\n" + 
			"<input type=\"radio\" name=\"professor_param\" value=\"professor2\">Kataxwrhsh vathmologias ana mathima\r\n" + 
			"<br>\r\n" + 
			"<input type=\"submit\" value=\"So,let's go!\">\r\n" + 
			"</form>"+
			"</div>");
}
%>
</body>
</html>