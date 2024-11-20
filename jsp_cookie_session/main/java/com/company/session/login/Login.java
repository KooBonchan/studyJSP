package com.company.session.login;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if(validate(id, password)) {
			var session = request.getSession();
			session.setAttribute("token", id);
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/login.html?error='auth-failed'");
		}
		
	}

	private boolean validate(String id, String password) {
		return id.length() > 0 && password.length() > 0;
	}
}
