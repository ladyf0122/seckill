package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	@Autowired
	private SeckillDao seckilldao;
	
	@Test
	public void testReduceNumber() throws Exception {
		Date killTime = new Date();
		int res = seckilldao.reduceNumber(1000L, killTime);
		System.out.println(res);
	}
	
	@Test
	public void testQueryById() throws Exception {
		long id = 1001;
		Seckill seckill = seckilldao.queryById(id);
		System.out.println(seckill);
	}
	
	@Test
	public void testQuetyAll() throws Exception {
		List<Seckill> list = seckilldao.quetyAll(0, 100);
		for(Seckill seckill : list) {
			System.out.println(seckill);
		}
	}
}
