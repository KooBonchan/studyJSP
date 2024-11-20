package com.company.member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberDAO dao;
	public SignUp() {
		dao = new MemberDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setEmail(email);
		if(dao.createMember(vo)) {
			response.sendRedirect("/member");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("Failed to make user. Retry");
			out.print("<script>");
			out.print("setTimeout(function(e){history.back()},1000)");
			out.print("</script>");
			out.print("</html>");
		    
		}
	}
}
