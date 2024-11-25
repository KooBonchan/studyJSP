package com.company.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String email;
	private Date joinDate;
}
