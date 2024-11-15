package com.company.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signup")
public class MemberSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private void fallback(HttpServletResponse response) throws IOException{
		response.sendRedirect("signup.html");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fallback(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		
		String _id = request.getParameter("id");
		String _password = request.getParameter("password");
		String _name = request.getParameter("name");
		String _email = request.getParameter("email");
		
		MemberVO vo = new MemberVO();
		vo.setId(_id);
		vo.setPassword(_password);
		vo.setName(_name);
		vo.setEmail(_email);
		//vo.validate();
		
		if(dao.createMember(vo)) {
			response.sendRedirect("member");
		} else {
			fallback(response);
		}
	}
}
