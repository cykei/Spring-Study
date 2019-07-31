package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample2Mapper {
	
	//create table tbl_sample2( col2 varchar2(50));
	
	@Insert("insert into tbl_sample2 (col2) values (#{data})")
	public int insertCol2(String data);
}
