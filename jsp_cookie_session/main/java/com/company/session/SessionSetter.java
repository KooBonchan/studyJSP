package com.company.session;


import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/session")
public class SessionSetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		var out = response.getWriter();
		var session = request.getSession();
		String id = session.getId();
		Date creationTime = new Date(session.getCreationTime());
		Date lastAccessedTime = new Date(session.getLastAccessedTime());
		int leftTime = session.getMaxInactiveInterval();
		out.print(
			"<body style='font-size:20px;font-weight:bold;'>" + 
			"id: " + id + "<br>" +
			"Creation Time: " + creationTime+ "<br>" +
			"Last Accessed: " + lastAccessedTime+ "<br>" +
			"Valid time: " + leftTime + "<br>"
		);
		
		if(session.isNew()) {
			out.print("new session");
		}
		
		out.print("</body>");
		
		session.invalidate();
		
		
	}

}
