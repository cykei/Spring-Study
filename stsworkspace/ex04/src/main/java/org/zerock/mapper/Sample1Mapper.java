package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {
	
	// create table tbl_sample1( col1 varchar2(500));
	
	@Insert("insert into tbl_sample1 (col1) values (#{data}) ")
	public int insertCol1(String data);
}
