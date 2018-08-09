package com.xixi.doubleTableSelect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xixi.doubleTableSelect.entity.Goods;

public interface GoodsMapper {
	List<Goods> selectGoods();
	int insertGoods(Goods goods);
}
