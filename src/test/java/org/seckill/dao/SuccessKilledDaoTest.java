package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
	
	@Autowired
	private SuccessKilledDao successkilleddao;
	
	@Test
	public void testInsertSuccessKilled() throws Exception {
		int res = successkilleddao.insertSuccessKilled(1000L, 13523567842L);
		System.out.println(res);
	}
	
	@Test
	public void testQuetyByIdWithSeckill() throws Exception {
		SuccessKilled successkilled = successkilleddao.quetyByIdWithSeckill(1000L,13523567842L);
		System.out.println(successkilled);
		System.out.println(successkilled.getSeckill());
	}
}
