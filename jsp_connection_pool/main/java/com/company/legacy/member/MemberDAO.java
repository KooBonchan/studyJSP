/**
 * 
 */
package com.company.legacy.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	static final String driver="oracle.jdbc.OracleDriver";
	static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	static final String db_user="kbc";
	static final String db_password="kbc";
	public List<MemberVO> readAllMember() {
		List<MemberVO> list = new ArrayList<>();
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.err.println("Developer Typo Error on class loading");
			return null;
		}
		
		String sql = "select * from member";
		System.out.println(sql);
		try(Connection connection = DriverManager.getConnection(
				url,
				db_user,
				db_password);
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
