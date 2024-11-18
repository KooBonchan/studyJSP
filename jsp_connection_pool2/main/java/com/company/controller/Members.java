package com.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.company.dao.MemberDAO;
import com.company.vo.MemberVO;

@WebServlet("/members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO dao;
	public Members(){
		dao = new MemberDAO();
		//injected by service?
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<MemberVO> members = dao.readAllMember();
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='pink'>");
		out.print("<td>ID</td>");
		out.print("<td>password</td>");
		out.print("<td>name</td>");
		out.print("<td>email</td>");
		out.print("<td>join date</td>");
		out.print("<td>Delete</td>");
		out.print("</tr>");
		for (MemberVO member : members) {
			out.print("<tr>");
			out.print("<td>"+ member.getId()+"</td>");
			out.print("<td>"+ member.getPassword()+"</td>");
			out.print("<td>"+ member.getName()+"</td>");
			out.print("<td>"+ member.getEmail()+"</td>");
			out.print("<td>"+ member.getJoinDate()+"</td>");
			out.print("<td><a href='member-delete?id="+member.getId()+"'>삭제</a></td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
		out.print("<a href='signup.html'>Sign up New Member</a>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
