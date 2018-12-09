package com.eakonovalov.spring5didemo.config;

import com.eakonovalov.spring5didemo.beans.FakeDatasource;
import com.eakonovalov.spring5didemo.beans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
*/
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
/*
@PropertySources({
        @PropertySource("classpath:/datasource.properties"),
        @PropertySource("classpath:/jms.properties")
})
*/
public class PropertiesConfiguration {

    @Value("${spring5didemo.database.username}")
    private String dbUsername;
    @Value("${spring5didemo.database.password}")
    private String dbPassword;
    @Value("${spring5didemo.database.url}")
    private String dbUrl;

    @Value("${spring5didemo.jms.username}")
    private String jmsUsername;
    @Value("${spring5didemo.jms.password}")
    private String jmsPassword;
    @Value("${spring5didemo.jms.url}")
    private String jmsUrl;


    @Bean
    public FakeDatasource fakeDatasource() {
        return new FakeDatasource(dbUsername, dbPassword, dbUrl);
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        return new FakeJmsBroker(jmsUsername, jmsPassword, jmsUrl);
    }

/*
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
*/

}
