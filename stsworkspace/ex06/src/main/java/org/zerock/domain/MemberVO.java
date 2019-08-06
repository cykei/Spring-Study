package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	/*
	 		create table tbl_member(
			userid varchar2(50) not null primary key,
			userpw varchar2(100) not null,
			username varchar2(100) not null,
			regdate date default sysdate,
			updatedate date default sysdate,
			enabled char(1) default '1' );
		
	 */
	
	private String userid;
	private String userpw;
	private String userName;
	private boolean enabled;
	
	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList;
}
