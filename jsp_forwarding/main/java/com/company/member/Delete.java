package com.company.member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao;
	public Delete() {
		dao = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		if(id != null && dao.deleteMember(id)) {
			response.sendRedirect("/member");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.print("Failed to delete. Redirecting");
		    out.print("<script>");
		    out.print("setTimeout(function() { window.location.href = '/member'; }, 1000);");
		    out.print("</script>");
		    out.print("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
