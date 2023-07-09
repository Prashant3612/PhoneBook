<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/bootstrap.jsp" %>
</head>
<body style="background-color:#f7faf8">
<%@include file="components/navbar.jsp" %>
<div class="container-fluid">
	<div class="row p-2">
	
	<div class="card mx-auto col-10 col-md-8 col-lg-6 my-3">
	
		<h4 class="text-center text-success p-3">Registration Page</h4>
		
		<%String sucssMsg=(String) session.getAttribute("sucessMsg");
		 String errorMsg=(String) session.getAttribute("errorMsg");
		if(sucssMsg!=null){
			%>
			<p class="text-success text-center"><%=sucssMsg%></p> 
			<%
			session.removeAttribute("sucessMsg");
		}
		if(errorMsg!=null){
			%>
			<p class="text-danger text-center"><%=errorMsg %></p>
			<% 
			session.removeAttribute("errorMsg");
		}
		%>

<form action="register" method="post">
<div class="form-group mt-2">
    <label for="exampleInputEmail1">Enter Name</label>
    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
    
  </div>
  <div class="form-group mt-2">
    <label for="exampleInputEmail1">Email address</label>
    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    
  </div>
  <div class="form-group mt-2">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="text-center p-4 ">
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