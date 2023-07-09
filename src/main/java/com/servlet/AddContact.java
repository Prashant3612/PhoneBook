package com.servlet;

import java.io.IOException;

import com.conn.Dbconnect;
import com.dao.ContactDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Contact;

/**
 * Servlet implementation class AddContact
 */
@WebServlet("/addContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userid"));
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phno=request.getParameter("number");
		String about=request.getParameter("about"); 
		
		Contact c=new Contact(name,email,phno,about,userId);
		ContactDao dao=new ContactDao(Dbconnect.getConn());
		
		boolean f=dao.saveContact(c);
		HttpSession session=request.getSession();
		if(f) {
			session.setAttribute("succMsg","Your contact saved successfully");
			
			response.sendRedirect("addContact.jsp");
			
			}
			else {
				session.setAttribute("failedMsg","Something went wrong on server");
				response.sendRedirect("addContact.jsp");
			}
		}
	}


