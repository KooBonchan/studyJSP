package com.company;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet(urlPatterns="/post-servlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private String sha256(String password) {
		try{
			final String saltString = "Chopin Nocturne No.09";
			String dataString = password + saltString;
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataString.getBytes("UTF-8"));
			StringBuilder hexStringBuilder = new StringBuilder();
			for(byte b: hash) {
				hexStringBuilder.append(String.format("%02x", b));
			}
			return hexStringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Typo on algorithm");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Typo on encoding");
		}
		return "";
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		password = sha256(password);
		
		var out = response.getWriter();
		out.print("""
				<html>
				<head>
				<style>
				html{
					background-color: #333;
					color:#fff;
				}
				</style>
				</head>
				<body>
				<h1>Get Servlet</h1>
				<table>
					<tr>
						<td><b>id</b></td>
						<td>
						"""+ id +"""
						</td>
					</tr>
					<tr>
						<td><b>password</b></td>
						<td>
						""" + password + """
						</td>
					</tr>
					<tr>
						<td><b>email</b></td>
						<td>
						""" + email + """
						</td>
					</tr>
				</table>
				</body></html>
				""");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
