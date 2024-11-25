/**
 * 
 */
package com.company.file;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

/**
 * @author 04-14
 *
 */
public class FileUtil {
	public static String uploadFile(HttpServletRequest request, String saveDirectory) throws IOException, ServletException{
		//side effect: saves file
		Part part = request.getPart("file");
		System.out.println(part.getHeader("content-disposition"));
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
		//side effect: requires existing file -- expected with its name
		//to be pure: filename, time as parameter, extract filesys as separate method
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
