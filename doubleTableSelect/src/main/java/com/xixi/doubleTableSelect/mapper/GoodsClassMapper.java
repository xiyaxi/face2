package com.xixi.doubleTableSelect.mapper;

import java.util.List;

import com.xixi.doubleTableSelect.entity.GoodsClass;

public interface GoodsClassMapper {
	List<GoodsClass> selectGoodsClass();
	
	int insertGoodsClass(GoodsClass goodsClass);
}
