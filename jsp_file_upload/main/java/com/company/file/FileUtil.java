/**
 * 
 */
package com.company.file;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

/**
 * @author 04-14
 *
 */
public class FileUtil {
	public static List<String> multiFile(HttpServletRequest request, String directory) throws IOException, ServletException{
		List<String> files = new ArrayList<>();
		Collection<Part> parts = request.getParts();
		for(var part : parts) {
			if(!part.getName().equals("file")) continue;
			String filename = part.getHeader("content-disposition")
					.split("filename=")[1]
					.trim().replace("\"", "");
			if( ! filename.isBlank()) {
				part.write(directory + File.separator + filename);
			}
			files.add(filename);
		}
		return files;
	}
	
	public static String uploadFile(HttpServletRequest request, String saveDirectory) throws IOException, ServletException{
		Part part = request.getPart("file");
		String[] rawFilenames = part
					.getHeader("content-disposition")
					.split("filename=");
		String original = rawFilenames[1].trim().replace("\"", "");
		if( ! original.isBlank()) {
			part.write(saveDirectory + File.separator + original);
		}
		return original;
	}
	
	public static String renameFile(String directory, String filename) {
		// extract new-filename-creation logic from file renaming
		// since filename logic is business logic
		String format = filename.substring(filename.lastIndexOf("."));
		String now = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
				+ String.format("-%d", LocalTime.now().toNanoOfDay() / 1000);
		String newFileName = now + format;
		File oldFile = new File(directory + File.separator + filename);
		File newFile = new File(directory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		return newFileName;
		
	}
}
