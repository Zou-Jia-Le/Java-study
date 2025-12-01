package com.imooc.object_project.sample5;

import com.imooc.object_project.sample5.system.CustomerService;
import com.imooc.object_project.sample5.system.Language;

public class Customer {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Language language = customerService.contact(86);
        language.voice();
    }
}
