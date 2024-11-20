package com.company.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		

		String name = request.getParameter("name");
		if(name == null) name = "Default";
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("name: " + name + "<br>");
		out.println("name: " + name + "<br>");
		out.println("<body><html>");

	}

}
