package com.eakonovalov.spring5didemo;

import com.eakonovalov.spring5didemo.controllers.ConstructorInjectedController;
import com.eakonovalov.spring5didemo.controllers.GetterInjectedController;
import com.eakonovalov.spring5didemo.controllers.MyController;
import com.eakonovalov.spring5didemo.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.eakonovalov.services", "com.eakonovalov.spring5didemo.controllers"})
@SpringBootApplication
public class Spring5DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Spring5DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        System.out.println(controller.hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
    }

}
