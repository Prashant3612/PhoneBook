<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/bootstrap.jsp" %>
<%@page import ="com.entity.User" %>
<%@page import ="com.entity.Contact" %>
<%@page import ="com.conn.Dbconnect" %>
<%@page import ="com.dao.ContactDao" %>
</head>
<body style="background-color:#f7faf8">
<%@include file="components/navbar.jsp" %>

<%if(user==null){
	session.setAttribute("invalidMsg","Login please..");
	response.sendRedirect("login.jsp");
	}%>


<% 
String failedMsg=(String)session.getAttribute("failedMsg");
if(failedMsg!=null){
	%>
	<div class="alert alert-danger" role="alert">
				Something went wrong!
	</div>
<%} session.removeAttribute("failedMsg");
%>
	
<div class="container-fluid ">
	<div class="row mt-20">
	
	<div class="card mx-auto col-10 col-md-8 col-lg-6 my-3">
	
		<h4 class="text-center text-success p-3">Add Contact Page</h4>

<form action="update" method="post">

<% 
	
	int cid=Integer.parseInt(request.getParameter("cid"));
	ContactDao dao=new ContactDao(Dbconnect.getConn());
	Contact c=dao.getContactByID(cid);
	
	%>
<input type="hidden" value="<%=cid%>" name="cid">

<div class="form-group mt-2">
    <label for="exampleInputEmail1">Enter Name</label>
    <input value="<%=c.getName() %>" input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
    
  </div>
  <div class="form-group mt-2">
    <label for="exampleInputEmail1">Email address</label>
    <input value="<%=c.getEmail() %>" input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
    
  </div>
  <div class="form-group mt-2">
    <label for="exampleInputPassword1">Enter Phone Number</label>
     <input value="<%=c.getPhno() %>" name="number" type="number" class="form-control" id="exampleInputPassword1" >
  </div>
  <div class="form-group mt-3">
    
    <textarea class="form-control" id="exampleFormControlTextarea1" name="about" rows="3" placeholder="Enter About"><%=c.getAbout() %></textarea>
  </div>
  <div class="text-center p-4">
   <button type="submit" class="btn btn-primary">Submit</button>
  </div>
 
</form>
</div>
</div>
</div>
<div style=" position: absolute;
  bottom: 0;
  width: 100%;
  height: 50px;">
<%@include file="components/footer.jsp" %>
</div>

</body>
</html>