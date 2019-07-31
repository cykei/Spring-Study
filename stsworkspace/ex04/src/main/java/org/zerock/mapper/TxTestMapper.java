package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.test.annotation.Commit;
import org.zerock.domain.txVO;

public interface TxTestMapper {

	@Insert("insert into tbl_tx (tid, likes, quantity) values (tx_sq.nextval, #{likes}, #{quantity}) ")
	public void insertRow(Long likes, Long quantity);
	
	@Update("update tbl_tx set(likes,quantity) = (#{likes}, #{quantity}) where tid=#{tid}")
	public void updateRow(Long tid, Long likes, Long quantity);
	
	@Update("update tbl_tx set likes = likes+1 where tid=#{tid} ")
	public void LikeInc(Long tid);
	
	@Update("update tbl_tx set quantity = quantity+1 where tid=#{tid} ")
	public void QttInc(Long tid);
	
	@Update("update tbl_tx set likes = likes-1 where tid=#{tid} ")
	public void Likedec(Long tid);
	
	@Update("update tbl_tx set quantity = quantity-1 where tid=#{tid} ")
	public void Qttdec(Long tid);
	
	@Select("select * from tbl_tx where tid=#{tid}")
	public txVO showRow(Long tid);
	
	@Select("select * from tbl_tx where tid=#{tid} for update")
	public txVO FUshowRow(Long tid);
	
	@Commit()
	public void  nowCommit();
}
