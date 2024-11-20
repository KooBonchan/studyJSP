package com.company.binding;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/binding/fetcher")
public class Fetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		DummyBean dummyBean = (DummyBean) request.getAttribute("dummy");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Dispatch</h1>");
		out.println(dummyBean);
		out.println("</body></html>");

	}

}
