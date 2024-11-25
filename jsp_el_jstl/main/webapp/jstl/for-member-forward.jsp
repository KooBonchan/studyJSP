<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	List<MemberVO> members = new ArrayList<>();
	Random random = new Random();
	
	int[] randoms = random
					.ints(10,1000,999999).toArray();
	
	for(int i = 10; i >0; i--){
		MemberVO member = new MemberVO();
		member.setId       ( "member" + i                  );
		member.setPassword ( "" + randoms[i-1]);
		member.setName     ( "Je " + i + " Ahae"           );
		member.setEmail    ( "rushes@on.the.road"        );
		member.setAddress  ( "No Rush is OK"               );
		members.add(member);
	}
	request.setAttribute("members", members);	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<jsp:forward page="for-member-info.jsp" />
</body>
</html>