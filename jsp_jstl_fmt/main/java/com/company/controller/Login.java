package com.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.company.dao.MemberDAO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberDAO dao;
	public Login() {
		dao = new MemberDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id =request.getParameter("id");
		String password = request.getParameter("password");
		if( id != null &&
			password != null &&
			dao.login(id, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("token", id);
			response.sendRedirect("members");
		}else {
//			somehow send error message - signup failed
			response.sendRedirect("login.html");
		}
	}

}
