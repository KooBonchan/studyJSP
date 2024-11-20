package com.company.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	DataSource dataSource;
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
	public List<MemberVO> readAllMembers(){
		String sql = "select id, password, name, email, join_date from member";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery())
		{
			List<MemberVO> members = new ArrayList<>();
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				
				Date date = resultSet.getDate("join_date");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPassword(password);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(date);
				members.add(vo);
			}
			return members;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
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
