package com.company.binding;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/binding/binder")
public class Binder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		DummyBean bassTrack = new DummyBean(
            "Deep Vibes", // Title
            "BassMaster 3000", // Artist
            "Electronic", // Genre
            240, // 4 minutes
            "Bass Heaven", // Album
            "2024-11-15", // Release Date
            "Electric Bass", // Bass Type
            9, // Bass Intensity (High intensity)
            "A pulsating track that showcases powerful, deep basslines that dominate the soundscape." // Description
        ); // gpt generated dummy bean
		
		request.setAttribute("dummy", bassTrack);
		
//		response.sendRedirect("fetcher"); // cannot fetch the attribute, for redirect get.
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("fetcher");
		dispatcher.forward(request, response);
		
	}
}
