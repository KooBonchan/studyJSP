package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.company.vo.MemberVO;

public class MemberDAO {
	
	private DataSource dataSource;
	public MemberDAO() {
		try{
			Context context = new InitialContext();
			Context environment = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) environment.lookup("jdbc/oracle");
			// injected by Service
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public List<MemberVO> readAllMember(){
		List<MemberVO> result = new ArrayList<>();
		String sql = "SELECT "
				+ "id, password, name, email, join_date "
				+ "FROM member";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
		){
			while(resultSet.next()) {
				MemberVO vo = new MemberVO();
				vo.setId      (resultSet.getString("id"));
				vo.setPassword(resultSet.getString("password"));
				vo.setName    (resultSet.getString("name"   ));
				vo.setEmail   (resultSet.getString("email"  ));
				vo.setJoinDate(resultSet.getDate("join_date"));
				result.add(vo);
			}
			return result;
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
		}
		return null; // error case: return null, not throw error.
	}
	
	public boolean login(String id, String password) {
		//Hash before DAO
		String sql = "SELECT "
				+ "name "
				+ "FROM member "
				+ "where id = ? and password = ? ";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql))
		{
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				if(resultSet.next()) {
					return true;
				}
			}	
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
		}
		return false;
	}
	
	public boolean idExists(String id) {
		//Hash before DAO
		String sql = "SELECT "
				+ "name "
				+ "FROM member "
				+ "where id = ?";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql))
		{
			preparedStatement.setString(1, id);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				if(resultSet.next()) {
					return true;
				}
			}	
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
		}
		return false;
	}
	
	public boolean createMember(MemberVO vo) {
		String sql = "INSERT INTO member "
				+ "(id, password, name, email) "
				+ "values (?,?,?,?)";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql))
		{
			preparedStatement.setString(1, vo.getId());
			preparedStatement.setString(2, vo.getPassword());
			preparedStatement.setString(3, vo.getName());
			preparedStatement.setString(4, vo.getEmail());
			int result = preparedStatement.executeUpdate();
			if(result > 0) return true;
		} catch (SQLException e) {
			 System.err.println("SQL Error: " + e.getMessage());
		}
		return false;
	}
	
	public boolean deleteMember(MemberVO vo) {
		return deleteMember(vo.getId());
	}
	
	public boolean deleteMember(String id) {
		String sql = "DELETE FROM member "
				+ "WHERE id = ?";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql))
		{
			preparedStatement.setString(1, id);
			int result = preparedStatement.executeUpdate();
			if(result > 0) return true;
			
		} catch (SQLException e) {
			 System.err.println("SQL Error: " + e.getMessage());
		}
		return false;
	}
}