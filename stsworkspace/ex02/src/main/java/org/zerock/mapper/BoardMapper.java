package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	//bno 값을 몰라도 됨.
	public void insert(BoardVO board);
	
	//bno 값을 알아야 함.
	public void insertSelectKey(BoardVO board);
	
	//bno를 써서 읽는다.
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
