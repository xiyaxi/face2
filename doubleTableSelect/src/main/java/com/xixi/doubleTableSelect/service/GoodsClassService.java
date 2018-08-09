package com.xixi.doubleTableSelect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xixi.doubleTableSelect.entity.GoodsClass;
import com.xixi.doubleTableSelect.mapper.GoodsClassMapper;

@Service
public class GoodsClassService {

	@Autowired
	private GoodsClassMapper goodsClassMapper;
	
	public List<GoodsClass> selectGoodsClass(){
		return goodsClassMapper.selectGoodsClass();
	}
	
	public int insertGoodsClass(GoodsClass goodsClass) {
		return goodsClassMapper.insertGoodsClass(goodsClass);
	}
}
