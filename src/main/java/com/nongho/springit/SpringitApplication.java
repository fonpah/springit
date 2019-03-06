package com.nongho.springit;

import com.nongho.springit.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    @Autowired
    private SpringitProperties springitProperties;
    private static Logger logger = LoggerFactory.getLogger(SpringitApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(){
        return arg -> {
            System.out.println("Our message is : " + springitProperties.getWelcomeMsg());
            logger.warn("warning");
            logger.error("Error");
            logger.info("Info");
        };
    }

}

