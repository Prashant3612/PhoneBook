<%@page import ="com.entity.User" %>



<nav class="navbar navbar-expand-lg navbar-light " style="background-color:blue">

  <div class="container-fluid">
    <a class="navbar-brand" href="#" style="color:white"><i class="fa-solid fa-square-phone" ></i>PhoneBook</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp" style="color:white"><i class="fa-solid fa-house"></i>Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="addContact.jsp" style="color:white"><i class="fa-solid fa-square-plus"></i>Add contact</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="viewContact.jsp" style="color:white"><i class="fa-solid fa-eye"></i>View Contact</a>
        </li>
        
      </ul>
      
      <% User user=(User) session.getAttribute("user");
      if(user==null){
    	  %>
    	  <form class="form-inline my-2 my-lg-0">
        <a href="login.jsp" class="btn btn-success mx-2">Login</a>
        <a href="Register.jsp" class="btn btn-danger mx-2">Register</a>
        </form>
        
         
      
      <% 
      }else{%>
    	 <form class="form-inline my-2 my-lg-0">
    	  <button class="btn btn-success"><%=user.getName() %></button>
    	  <a href="logout" class="btn btn-danger ml-2" >Logout</a>
    	  </form>
      <%}
      %>
      
      
      
    
      
    </div>
  </div>
</nav>