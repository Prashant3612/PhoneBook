package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.Dbconnect;
import com.dao.ContactDao;
import com.entity.Contact;

/**
 * Servlet implementation class editContact
 */
@WebServlet("/update")
public class editContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(request.getParameter("cid"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("number");
		String about=request.getParameter("about"); 
		
		Contact c=new Contact();
		c.setName(name);
		c.setEmail(email);
		c.setPhno(phno);
		c.setAbout(about);
		c.setUserId(cid);
		
		ContactDao dao=new ContactDao(Dbconnect.getConn());
		
		boolean f=dao.updateContact(c);
		HttpSession session=request.getSession();
		if(f) {
			session.setAttribute("succMsg","Your contact updated successfully");
			
			response.sendRedirect("viewContact.jsp?cid="+cid);
			
			}
			else {
				session.setAttribute("failedMsg","Something went wrong on server");
				response.sendRedirect("editContact.jsp?cid="+cid);
			}
	}

}
