package com.company.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVO {
	String id;
	String password;
	String name;
	String email;
	Date joinDate;
}
