package com.imooc.object_project.sample3;

public class MobileNumber {
    //成员变量
    private String owner;//所有者
    private String areacode = "86";//国家区号
    private long number;//手机号

    //getter、setter方法
    public String getOwner() {
        return this.owner;
    }
    public void  setOwner(String owner) {
        this.owner = owner;
    }
    public String getAreacode() {
        return this.areacode;
    }
    /*public void setAreacode(String areacode) {
        this.areacode = areacode;
    }*/
    public long getNumber() {
        return this.number;
    }
    public void setNumber(long number) {
        this.number = number;
    }
}
