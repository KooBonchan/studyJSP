package com.company.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig(
		location = "c:/temp",
		maxFileSize = 5 * 1024 * 1024,
		maxRequestSize = 10 * 1024 * 1024
		)
@WebServlet("/file-download")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileDAO fileDAO;
	{
		fileDAO = new FileDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String saveDirectory = getServletContext().getRealPath("/uploads");
			int i = Integer.parseInt(request.getParameter("idx"));
			FileVO fileVO = fileDAO.readFile(i);
			
			
			File file = new File(saveDirectory, fileVO.getSaved());
			response.reset();
			response.setContentType("application/octet-stream");
			response.setHeader("content-disposition", "attachment; filename=\""+fileVO.getOriginal()+"\"");
			response.setHeader("content-length", "" + file.length());
			
			try(InputStream inputStream = new FileInputStream(file);
				OutputStream outputStream = response.getOutputStream();)
			{
				byte b[] = new byte[(int)file.length()];
				int readBuffer = 0;
				while((readBuffer = inputStream.read(b)) > 0) {
					outputStream.write(b, 0, readBuffer);
				}
			}
		} catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
			request.setAttribute("errorMessage", "Error while deleting a file");
			response.sendRedirect("file-list");
						
		}
	}
}
