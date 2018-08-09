package com.xixi.doubleTableSelect.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xixi.doubleTableSelect.entity.GoodsClass;
import com.xixi.doubleTableSelect.service.GoodsClassService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})
public class GoodsClassTest {
	
	@Autowired
	private GoodsClassService goodsClassService;
	
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("¿ªÊ¼");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("½áÊø");
	}

	@Test
	public void testSelectAll() {
		List<GoodsClass> list=goodsClassService.selectGoodsClass();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		Assert.assertNotNull(list);
	}

}
