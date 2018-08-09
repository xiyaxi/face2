package com.xixi.doubleTableSelect.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.xixi.doubleTableSelect.entity.Goods;
import com.xixi.doubleTableSelect.entity.GoodsClass;
import com.xixi.doubleTableSelect.service.GoodsClassService;
import com.xixi.doubleTableSelect.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})
@Transactional
public class GoodsTest {
	@Autowired
	private GoodsService goodsService;
	
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
		List<Goods> list=goodsService.selectGoods();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		Assert.assertNotNull(list);
	}
	
	
	@Test
	@Rollback(false)
	public void testInsert() {
		
		GoodsClass goodsClass=new GoodsClass();
		goodsClass.setGoodsClassName("abc");
		
		Goods goods=new Goods();
		goods.setGoodsName("xi");
		goods.setGoodsPrice(100);
		goods.setGoodsType("abc");
		goods.setGoodsClassId(1);
		int a=goodsClassService.insertGoodsClass(goodsClass);
		int z=0/0;
		int i=goodsService.insertGoods(goods);
		System.out.println(i+"--"+a);
		
		
		
	}
}
