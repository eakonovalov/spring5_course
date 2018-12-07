package com.eakonovalov.spring5petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("demo")
public class DemoDataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    }
}
