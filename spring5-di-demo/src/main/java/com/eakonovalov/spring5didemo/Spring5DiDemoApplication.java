package com.eakonovalov.spring5didemo;

import com.eakonovalov.spring5didemo.beans.FakeDatasource;
import com.eakonovalov.spring5didemo.beans.FakeJmsBroker;
import com.eakonovalov.spring5didemo.controllers.ConstructorInjectedController;
import com.eakonovalov.spring5didemo.controllers.GetterInjectedController;
import com.eakonovalov.spring5didemo.controllers.MyController;
import com.eakonovalov.spring5didemo.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@ComponentScan(basePackages = {"com.eakonovalov.spring5didemo.config", "com.eakonovalov.spring5didemo.services", "com.eakonovalov.spring5didemo.controllers"})
@SpringBootApplication
public class Spring5DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Spring5DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        System.out.println("============================================================");

        System.out.println(controller.hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

        System.out.println("============================================================");

        FakeDatasource ds = ctx.getBean(FakeDatasource.class);
        System.out.println(ds.getUsername());
        System.out.println(ds.getPassword());
        FakeJmsBroker jms = ctx.getBean(FakeJmsBroker.class);
        System.out.println(jms.getUsername());
        System.out.println(jms.getPassword());

        System.out.println("============================================================");
    }
}
