package com.company.file;

import java.io.File;
import java.io.IOException;

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
@WebServlet("/multi-file")
public class MultiUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileDAO fileDAO;
	{
		fileDAO = new FileDAO();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String saveDirectory = getServletContext().getRealPath("/uploads");
			File dir = new File(saveDirectory);
			if( ! dir.exists()) {
				dir.mkdir();
			}
			var filenames = FileUtil.multiFile(request, saveDirectory);
			for(String original : filenames) {
				String saved = FileUtil.renameFile(saveDirectory, original);
				
				String title = request.getParameter("title");
				FileVO fileVO = new FileVO();
				fileVO.setTitle(title);
				fileVO.setOriginal(original);
				fileVO.setSaved(saved);
				
				fileDAO.createFile(fileVO);
			}
			response.sendRedirect("file-list");
		} catch(Exception e) {
			System.err.println("Error: " + e.getMessage());
			request.setAttribute("errorMessage", "Error while uploading a file");
			request.getRequestDispatcher("file-upload.jsp").forward(request, response);
						
		}
	}
}
