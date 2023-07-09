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

/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/delete")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		ContactDao dao=new ContactDao(Dbconnect.getConn());
		
		boolean f=dao.deleteContactById(cid);
		HttpSession session=request.getSession();
		if(f) {
			session.setAttribute("succMsg", "Contact deleted Successfully..");
			response.sendRedirect("viewContact.jsp");
		}else {
			session.setAttribute("failedMsg", "something went wrong..");
			response.sendRedirect("viewContact.jsp");
		}
	}

	
}
