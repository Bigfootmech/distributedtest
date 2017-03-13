package org.distributedtest.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan
@EnableWebMvc
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@Import({ org.distributedtest.dao.App.class})
public class App extends WebMvcConfigurerAdapter {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}

