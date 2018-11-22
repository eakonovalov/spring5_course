package com.eakonovalov.spring5idea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5ideaApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Spring5ideaApplication.class, args);
        GreetingController controller = ctx.getBean(GreetingController.class);
        controller.sayHello();
    }

}
