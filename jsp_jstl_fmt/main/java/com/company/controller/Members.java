package com.company.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.company.dao.MemberDAO;
import com.company.vo.MemberVO;

@WebServlet("/members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO dao;
	public Members(){
		dao = new MemberDAO();
		//injected by service?
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<MemberVO> members = dao.readAllMember();
		request.setAttribute("members", members);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member-list.jsp");
		dispatcher.forward(request, response);
		
	}

}
