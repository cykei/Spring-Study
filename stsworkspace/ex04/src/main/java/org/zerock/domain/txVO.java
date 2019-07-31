package org.zerock.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class txVO {
	
	/*
	 *  create table tbl_tx(
		tid number(10,0) not null,
		likes number(10,0),
		quantity number(10,0)
		);
	 */
	private Long tid;
	private Long likes;
	private Long quantity;
	
}
