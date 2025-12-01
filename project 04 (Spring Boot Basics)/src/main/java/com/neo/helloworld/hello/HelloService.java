package com.neo.helloworld.hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    //成员方法
    public void sayHello() {
        System.out.println("Hello World");
    }
}
