package com.company.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.time.LocalDateTime;

@WebServlet("/cookie/set")
public class CookieSetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Cookie cookie = new Cookie("cookieTest", 
				URLEncoder.encode("한글입력 테스트", "utf-8"));
//		cookie.setMaxAge(24*60*60); // 1 day
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		PrintWriter out = response.getWriter();
		out.println("Current: " + LocalDateTime.now());
		out.println("<br>Store test string as cookie");
	}

}
