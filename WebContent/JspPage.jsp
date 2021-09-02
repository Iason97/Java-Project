<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1" >
<style>
.vertical-menu {
    width: 500px;
    text-align: center;
        margin: auto;
}

.vertical-menu a {
    background-color: #eee;
    color: black;
    display: block;
    padding: 12px;
    font-size: 130%;
    text-decoration: underline;
}

.vertical-menu a:hover {
    background-color: #ccc;
}


</style>
</head>
<body>


<h1 style="color:blue;" align="center">Hello <%=request.getParameter("name")%></h1>




<div class="vertical-menu" align="center">
  <a href="SecretaryServlet?param=mathimata"  ><h4>Provoli synolou mathimatwn</h4></a><br>
  <a href="SecretaryServlet?param=mathimata2" ><h4>Provoli mathimatwn kai kathgiti ana mathima</h4></a><br>
  <a href="SecretaryServlet?param=professor" ><h4>Anathesi mathimatos se kathigiti.</h4></a><br>
</div>

</body>
</html>