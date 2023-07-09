package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.dao.UserDao;
import com.conn.Dbconnect;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User u=new User(name,email,password);
		
		UserDao dao=new UserDao(Dbconnect.getConn());
		boolean f=dao.userRegister(u);
		
		HttpSession session=request.getSession();
		if(f) {
			session.setAttribute("sucessMsg","user register sucessfully");
			response.sendRedirect("Register.jsp");
			System.out.print("super");
		}else {
			session.setAttribute("errorMsg","Something wrong");
			//System.out.println("Something wrong");
		}
	}
}
