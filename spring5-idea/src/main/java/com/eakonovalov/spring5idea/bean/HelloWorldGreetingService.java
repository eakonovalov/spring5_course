package com.eakonovalov.spring5idea.bean;

import com.eakonovalov.spring5idea.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("helloWorld")
public class HelloWorldGreetingService implements GreetingService {

    @Override
    public void sayHello() {
        System.out.println("Hello world!!!");
    }

}
