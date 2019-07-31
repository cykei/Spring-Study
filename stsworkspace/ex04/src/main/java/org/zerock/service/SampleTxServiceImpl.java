package org.zerock.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.*;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService{
	@Setter(onMethod_= {@Autowired})
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_= {@Autowired})
	private Sample2Mapper mapper2;
	
    @Transactional //이제 하나라도 두개의 insert 중 하나라도  fail되면 둘다 fail됨.
	@Override
	public void addData(String value) {
		log.info("mapper1.....................");
		mapper1.insertCol1(value);
		
		log.info("mapper2.....................");
		mapper2.insertCol2(value);
		
		log.info("end.........................");
	}
    
    // 여기서 부터 txTest
    
    @Setter(onMethod_= {@Autowired})
    private TxTestMapper txmapper;
    
    @Transactional
    @Override
    public void updataData(String userid, Long tid, Long likes, Long quantity) {
    	log.info(userid+" do update...............");
    	txmapper.updateRow(tid, likes, quantity);
    	
    	log.info(userid+"'s row is changed.........");
    	txmapper.showRow(tid);
    }
    
    @Override
    public void onlyShowData(String userid, Long tid) {
    	log.info(userid+" want to show some data........");
    	txmapper.FUshowRow(tid);
    }
    
    //@Transactional
  
    
    //@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=SQLException.class, timeout=10)
    @Override
    public void ILikeIt(String userid, Long tid){
    	log.info(userid+ "like the product.......");
    	txmapper.LikeInc(tid);
    	txmapper.showRow(tid);
    }
    
    //@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=SQLException.class, timeout=10)
    //@Transactional
    @Override
	public void IBuyIt(String userid, Long tid) {
		log.info(userid+"want to buy the product.......");
		txmapper.QttInc(tid);
		txmapper.showRow(tid);
	}
    
    @Override
    public void nowCommit() {
    	log.info("commit............");
    	txmapper.nowCommit();
    }

}
