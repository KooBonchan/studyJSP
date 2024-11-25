/**
 * 
 */
package com.company.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author 04-14
 *
 */
public class FileDAO {
	DataSource dataSource;
	{
		dataSource = ConnectionPoolProvider.getDataSource();		
	}
	
	public boolean createFile(FileVO file) {
		String sql = "INSERT INTO image "
				+ "(idx, title, original, saved) "
				+ "values "
				+ "(seq_image_idx.nextval, ?, ?, ?)";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql))
		{
			preparedStatement.setString(1, file.getTitle());
			preparedStatement.setString(2, file.getOriginal());
			preparedStatement.setString(3, file.getSaved());
			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(sql);
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	public List<FileVO> readAllFiles() {
		List<FileVO> files = new ArrayList<>();
		
		String sql = "select idx, title, original, saved, postdate from image";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery())
		{
			while(resultSet.next()) {
				FileVO file = new FileVO();
				int idx = resultSet.getInt("idx");
				String title = resultSet.getString("title");
				String original = resultSet.getString("original");
				String saved = resultSet.getString("saved");
				String postdate = resultSet.getString("postdate");
				file.setIdx(idx);
				file.setTitle(title);
				file.setOriginal(original);
				file.setSaved(saved);
				file.setPostdate(postdate);
				files.add(file);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(sql);
			System.err.println(e.getMessage());
		}
		return files;
	}
	
	public FileVO readFile(int idx) {
		String sql = "select original, saved from image where idx = ?";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			)
		{
			preparedStatement.setInt(1,idx);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				if(resultSet.next()) {
					String original = resultSet.getString("original");
					String saved = resultSet.getString("saved");
					
					FileVO vo = new FileVO();
					vo.setOriginal(original);
					vo.setSaved(saved);
					return vo;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
