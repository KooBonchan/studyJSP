package com.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import com.company.dao.MemberDAO;

@WebServlet("/id-check")
// REST api
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	MemberDAO dao;
	public IdCheck() {
		dao = new MemberDAO();
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("application/json;charset=utf-8");
    	String id = request.getParameter("id");
    	
    	JSONObject jsonResponse = new JSONObject();
    	jsonResponse.put("exists", dao.idExists(id));
        
    	PrintWriter out = response.getWriter();
        out.print(jsonResponse.toString());
        out.flush();
	}
}
