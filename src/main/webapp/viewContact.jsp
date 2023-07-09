<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/bootstrap.jsp" %>
</head>
<body>
<%@include file="/components/navbar.jsp" %>
<%@page import ="com.entity.User" %>
<%@page import ="com.entity.Contact" %>
<%@page import ="com.conn.Dbconnect" %>
<%@page import ="com.dao.ContactDao" %>
<%@page import ="java.util.*" %>
<%if(user==null){
	session.setAttribute("invalidMsg","Login please..");
	response.sendRedirect("login.jsp");
	}%>
	
	<style type="text/css">
	.crd-ho:hover{
	background-color:#f7f7f7;
	}
	
	</style>
	<%String s=(String)session.getAttribute("succMsg");
if(s!=null){
		%>
		<div class="alert alert-success" role="alert">
  				<%=(String)session.getAttribute("succMsg")%>
		</div>
		<% 
		session.removeAttribute("succMsg");
}

%>
	
	
	<div class="container">
	<div class="row p-4">
	
	
	<%
	if(user!=null){
	ContactDao dao=new ContactDao(Dbconnect.getConn());
	List<Contact> contact=dao.getAllContact(user.getId());
	for(Contact c:contact){
		%><div class="col-ml-3">
	<div class="card crd-ho">
		<div class="card-body">
	<h5>Name: <%=c.getName() %></h5>
	<p>Phone. No:<%=c.getPhno() %></p>
	<p>Email:<%=c.getEmail() %></p>
	<p>About:<%=c.getAbout() %></p>
	
	<div class="text-center">
	<a href="editContact.jsp?cid=<%=c.getId()%>" class="btn btn-success btn-sm">Edit</a>
	<a href="delete?cid=<%=c.getId()%>" class="btn btn-danger btn-sm">Delete</a>
	</div>
	</div>
	</div>
	<% }
	}
	%>
	
	
	
	</div> 
	</div>
	</div>

</body>
</html>