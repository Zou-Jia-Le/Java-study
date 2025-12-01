package com.neo.helloworld.service;

import com.neo.helloworld.hello.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

@SpringBootTest
public class HelloTest {
    @Resource
    HelloService helloService;

    @Test
    public void sayHelloTest() {
        helloService.sayHello();
    }
}
