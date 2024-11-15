/**
 * 
 */
package com.company.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			Context environment = (Context) context.lookup("java:/comp/env");
			dataFactory = (DataSource) environment.lookup("jdbc/oracle");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean createMember(MemberVO memberVO) {
		String id = memberVO.getId();
		String password = memberVO.getPassword();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		String sql = "INSERT INTO member "
				+ "(id, password, name, email) "
				+ "VALUES (?, ?, ?, ?)";
		try(Connection connection = dataFactory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql)
		){
			preparedStatement.setString(1,id);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,name);
			preparedStatement.setString(4, email);
			int result = preparedStatement.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	public List<MemberVO> readAllMember() {
		List<MemberVO> list = new ArrayList<>();
		
		String sql = "select * from member";
		try(Connection connection = dataFactory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
		){
			while(resultSet.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(resultSet.getString("id"));
				memberVO.setPassword(resultSet.getString("password"));
				memberVO.setName(resultSet.getString("name"));
				memberVO.setEmail(resultSet.getString("email"));
				memberVO.setJoinDate(resultSet.getDate("join_date"));
				list.add(memberVO);
			}
		} catch (SQLException e) {
			System.err.println("DB Connection Error");
		}
		
		return list;
	}
}
