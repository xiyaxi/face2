package com.xixi.doubleTableSelect.entity;

public class Goods {
	private int goodsId;
	private String goodsName;
	private String goodsType;
	public GoodsClass getGoodsClass() {
		return goodsClass;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsType=" + goodsType + ", goodsClass="
				+ goodsClass + ", goodsClassId=" + goodsClassId + ", goodsPrice=" + goodsPrice + "]";
	}
	public void setGoodsClass(GoodsClass goodsClass) {
		this.goodsClass = goodsClass;
	}
	private GoodsClass goodsClass;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public int getGoodsClassId() {
		return goodsClassId;
	}
	public void setGoodsClassId(int goodsClassId) {
		this.goodsClassId = goodsClassId;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	private int goodsClassId;
	private float goodsPrice;
}
