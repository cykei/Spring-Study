package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TestTransaction;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class SampleTxServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private SampleTxService service;
	
	@Test
	public void testLong() {
		String str= "Starry\r\n" + 
				"Starry night\r\n" +
				"Paint your palette bl"
				+ "ue and grey\r\n" +
				"Look out on a summer's day";
		log.info(str.getBytes().length);
		service.addData(str);
	}

	
	@Test
	public void testTx() {
		log.info(" 아무개가 일을 한다 하나, 둘, 셋! ");
		
		service.onlyShowData("아무개", 2L);
		
		log.info(" 개발자도 일을 한다 하나, 둘, 셋! ");
		service.onlyShowData("개발자", 2L);
		
		log.info(" 아무개는 2가 좋다! ");
		service.ILikeIt("아무개", 2L);
		
		log.info(" 개발자는 2를 사고싶다! ");
		service.IBuyIt("개발자", 2L);
		
		
	}
	
	
}
