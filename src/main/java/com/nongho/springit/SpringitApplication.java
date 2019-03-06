package com.nongho.springit;

import com.nongho.springit.config.SpringitProperties;
import com.nongho.springit.domain.Comment;
import com.nongho.springit.domain.Link;
import com.nongho.springit.repository.CommentRepository;
import com.nongho.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@EnableJpaAuditing
public class SpringitApplication {

    @Autowired
    private SpringitProperties springitProperties;
    private static Logger logger = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
        return arg -> {
            Link link = new Link("Spring boot", "https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-actuator");
            linkRepository.save(link);
            Comment comment =  new Comment("Test body", link);
            commentRepository.save(comment);
            link.getComments().add(comment);
        };
    }

}

