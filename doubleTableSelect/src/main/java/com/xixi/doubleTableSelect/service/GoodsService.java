package com.xixi.doubleTableSelect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xixi.doubleTableSelect.entity.Goods;
import com.xixi.doubleTableSelect.entity.GoodsClass;
import com.xixi.doubleTableSelect.mapper.GoodsClassMapper;
import com.xixi.doubleTableSelect.mapper.GoodsMapper;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	
	private GoodsClassMapper goodsClassMapper;
	
	public List<Goods> selectGoods(){
		return goodsMapper.selectGoods();
	}
	
	public int insertGoods(Goods goods) {
		
		
		return goodsMapper.insertGoods(goods);
	}
}
