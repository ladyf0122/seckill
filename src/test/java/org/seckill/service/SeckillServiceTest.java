package org.seckill.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class SeckillServiceTest {

	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() throws Exception {
		List<Seckill> list = seckillService.getSeckillList();
		for(Seckill seckill : list) {
			System.out.println(seckill);
		}
	}
	
	@Test
	public void testGetById() throws Exception {
		Seckill seckill = seckillService.getById(1001L);
		System.out.println(seckill);
	}
	
	@Test
	public void testSeckillLogic() throws Exception {
		long id = 1000L;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()) {
			try {
			long phone = 13526374872L;
			String md5 = exposer.getMd5();
			SeckillExecution seckillexecution = seckillService.executeSeckill(id, phone, md5);
			System.out.println(seckillexecution);
			}catch(RepeatKillException e) {
				System.out.println(e.getMessage());
			}catch(SeckillCloseException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println(exposer);
		}
	}
	
}
