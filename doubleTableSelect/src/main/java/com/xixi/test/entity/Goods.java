package com.xixi.test.entity;

public class Goods {
    private Integer goodsid;

    private String goodsname;

    private String goodstype;

    private Integer goodsclassid;

    private Float goodsprice;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype == null ? null : goodstype.trim();
    }

    public Integer getGoodsclassid() {
        return goodsclassid;
    }

    public void setGoodsclassid(Integer goodsclassid) {
        this.goodsclassid = goodsclassid;
    }

    public Float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Float goodsprice) {
        this.goodsprice = goodsprice;
    }
}