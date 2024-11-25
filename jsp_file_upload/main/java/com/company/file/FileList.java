package com.company.file;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/file-list")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileDAO fileDAO;
	{
		fileDAO = new FileDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<FileVO> files = fileDAO.readAllFiles();
		request.setAttribute("files", files);
		request.getRequestDispatcher("file-list.jsp").forward(request, response);
	}
}
