package com.company.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/fetcher")
public class Fetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		
		@SuppressWarnings("unchecked")
		List<MemberVO> members = (List<MemberVO>) request.getAttribute("members");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Dispatch</h1>");
		out.print("<table border=1><tr align='center' bgcolor='pink'>");
		out.print("<td>ID</td>");
		out.print("<td>password</td>");
		out.print("<td>name</td>");
		out.print("<td>email</td>");
		out.print("<td>join date</td>");
		out.print("<td>delete</td>");
		out.print("</tr>");
		if(members != null) {
			for (MemberVO member : members) {
				out.print("<tr>");
				String id = member.getId();
				out.print("<td>"+ id+"</td>");
				out.print("<td>"+ member.getPassword()+"</td>");
				out.print("<td>"+ member.getName()+"</td>");
				String email = member.getEmail();
				if(email == null) email = "";
				out.print("<td>"+ email +"</td>");
				out.print("<td>"+ format.format(member.getJoinDate())+"</td>");
				
				out.print("<td><a href='member/delete?id="+id+"'>del</a></td>");
				out.print("</tr>");
			}

		}
		out.print("</table>");
		out.print("<a href='signup.html'>Sign up New Member</a>");
		out.println("</body></html>");

	}

}
