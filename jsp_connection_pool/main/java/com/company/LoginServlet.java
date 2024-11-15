package com.company;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String SHA256(String string) {
		final String SALT = "Bae Bae Bassputin, Unstoppable Slap Machine";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] result = messageDigest.digest((string + SALT).getBytes());
			StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toString((result[i] & 0xFF) + 256, 16).substring(1));
            }
            return sb.toString();
		}catch (Exception e) {
			System.out.println("Developer Typo, Fix Quick");
		}
		
		
		return "";
	}
       
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get");
		handler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post");
		// Both request goes to handler
		handler(request, response);
	}
	
	void handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		System.out.println("id: " + id);
		System.out.println("password: " + password);
		String[] favorites = request.getParameterValues("favorite");
		if(favorites != null) {
			for(String favorite: favorites) {
				System.out.println("favorite: " + favorite);
			}
		}
		if(id.equals("admin") && password.equals("admin")) {
			out.print("<h1>You are Admin</h1>");
		}
		else if (id.equals("admin") || id.equals("administrator")) {
			out.print("<h1>Do not use admin ID</h1>");
		}
		else {
			out.print("""
					<html><body>
					<br> id:""" + id + """
					<br> password:""" + SHA256(password) + """
					</body></html>
					""");
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}
}
