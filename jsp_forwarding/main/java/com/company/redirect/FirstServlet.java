package com.company.redirect;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/redirect/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		
		out.print("Wait for seconds.");
//		response.sendRedirect("second?name=lee"); -- redirect immed
//		response.addHeader("Refresh", "1;url=second"); -- redirect after 1 sec
		out.print("<script>");
		out.print("location.href='second?name="+URLEncoder.encode("한글","utf-8")+"'");
		out.print("</script>");

		
	}
}
