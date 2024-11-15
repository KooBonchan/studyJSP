package com.company;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-try")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/*
	 * private String sha256(String password) { try{ final String saltString =
	 * "Chopin Nocturne No.09"; String dataString = password + saltString;
	 * MessageDigest digest = MessageDigest.getInstance("SHA-256"); byte[] hash =
	 * digest.digest(dataString.getBytes("UTF-8")); StringBuilder hexStringBuilder =
	 * new StringBuilder(); for(byte b: hash) {
	 * hexStringBuilder.append(String.format("%02x", b)); } return
	 * hexStringBuilder.toString(); } catch (NoSuchAlgorithmException e) {
	 * System.out.println("Typo on algorithm"); } catch
	 * (UnsupportedEncodingException e) { System.out.println("Typo on encoding"); }
	 * return ""; }
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id").strip();
		String password = request.getParameter("password").strip();
		
		if(id != null
				&& id.length() > 0
				&& password.length() > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("/studyServlet/logins/home.jsp");
			return;
		}
		response.sendRedirect("/studyServlet/logins/login.jsp");
		
	}

}
