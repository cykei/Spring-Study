package org.zerock.service;

public interface SampleTxService {
	public void addData(String value);
	
	public void updataData(String userid, Long tid, Long likes, Long quantity);
	
	public void onlyShowData(String userid, Long tid);
	
	public void ILikeIt(String userid, Long tid);
	
	public void IBuyIt(String userid, Long tid);
	
	public void nowCommit();
}
