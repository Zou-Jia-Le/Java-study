package com.imooc.object_project.sample3;

public class MobileNumberTestor {
    public static void main(String[] args) {
        MobileNumber mobileNumber = new MobileNumber();

        //mobileNumber.owner="小邹";
        //mobileNumber.areaCode="84";

        //修改 Owner
        mobileNumber.setOwner("小邹");
        String owner = mobileNumber.getOwner();
        System.out.println(owner);
        //修改 Areacode
        //mobileNumber.setAreacode("84");
        String areacode = mobileNumber.getAreacode();
        System.out.println(areacode);
        //修改 Numberr
        mobileNumber.setNumber(1234567890);
        long number = mobileNumber.getNumber();
        System.out.println(number);
    }
}
