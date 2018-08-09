package com.xixi.doubleTableSelect.entity;

import java.util.List;

public class GoodsClass {
 @Override
	public String toString() {
		return "GoodsClass [goodsClassId=" + goodsClassId + ", goodsClassName=" + goodsClassName + ", goodsa=" + goodsa
				+ "]";
	}
private int goodsClassId;
 private String goodsClassName;
 private List<Goods> goodsa;  

public List<Goods> getGoodsa() {
	return goodsa;
}
public void setGoods(List<Goods> goodsa) {
	this.goodsa = goodsa;
}
public int getGoodsClassId() {
	return goodsClassId;
}
public void setGoodsClassId(int goodsClassId) {
	this.goodsClassId = goodsClassId;
}
public String getGoodsClassName() {
	return goodsClassName;
}
public void setGoodsClassName(String goodsClassName) {
	this.goodsClassName = goodsClassName;
}
}
