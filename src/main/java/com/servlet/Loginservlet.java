package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.UserDao;
import com.entity.User;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("omg");
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		System.out.println("omg");
		UserDao dao=new UserDao(Dbconnect.getConn());
		User u=(User)dao.loginUser(email,pass);
		
		HttpSession session=req.getSession();
		if(u!=null) {
			session.setAttribute("user", u);
			res.sendRedirect("index.jsp");
			//System.out.println("available"+u);
		}else {
			session.setAttribute("invalidMsg", "Invalid email and password");
			res.sendRedirect("login.jsp");
			//System.out.println("not available"+u);
		}
	}

}
