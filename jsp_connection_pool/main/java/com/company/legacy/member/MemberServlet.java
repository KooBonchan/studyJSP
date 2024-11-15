package com.company.legacy.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.readAllMember();
		StringBuilder stringBuilder = new StringBuilder("""
				<html><body>
				<table border=1>
				<tr align='center' bgcolor='lightgreen'>
				<td>ID</td>
				<td>Password</td>
				<td>Name</td>
				<td>e-mail</td>				
				<td>Join Date</td>				
				</tr>
				""");
		for(MemberVO vo : list) {
			stringBuilder.append(String.format("""
				<tr>
				<td>%s</td>
				<td>%s</td>
				<td>%s</td>
				<td>%s</td>
				<td>%s</td>
				</tr>
					""",
					vo.getId(),
					vo.getPassword(),
					vo.getName(),
					vo.getEmail(),
					vo.getJoinDate().toString()));
		}
		stringBuilder.append("""
				</table>
				</body></html>
				""");
		out.print(stringBuilder.toString());
	}

}
