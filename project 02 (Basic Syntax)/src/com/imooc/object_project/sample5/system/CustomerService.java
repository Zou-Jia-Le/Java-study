package com.imooc.object_project.sample5.system;

public class CustomerService {
    //成员方法
    /**
     * @param areaCode
     * @return
     */
    public Language contact(int areaCode) {
        if(areaCode == 86){
            return new Chinese();
        }else if(areaCode == 33) {
            return new Franch();
        }else {
            return new English();
        }
    }

    public static void main(String[] args) {
        Language language2 = new Chinese();
        language2.voice();
        Language language1 = new English();
        language1.voice();

        CustomerService customerService = new CustomerService();
        Language language3 = customerService.contact(86);
        language3.voice();
    }
}
