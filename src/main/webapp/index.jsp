<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="components/styles.css"  type="text/css">
<title>Insert title here</title>
<%@include file="components/bootstrap.jsp" %>
<%@page import ="com.conn.Dbconnect" %>
<%@page import ="java.sql.Connection" %>
<style type="text/css">
.back-img{
	background: url("img/bg_main.png");
	width:100%;
	height:90vh;
	background-repeat:no-repeat;
	background-size:cover;
}
</style>


</head>
<body>
<%@include file="components/navbar.jsp" %>
<div class="container-fluid back-img text-center text-success">

<h1>Welcome</h1>
</div>


</body>
<div style=" position: absolute;
  bottom: 0;
  width: 100%;
  height: 50px;">
<%@include file="components/footer.jsp" %>
</div>
</html>