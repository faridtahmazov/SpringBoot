package com.company;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMongoRestApiApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoRestApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                User user = new User();
                user.setName("Farid");
                user.setSurname("Tahmazov");
                user.setAge(19);

                User user2 = new User();
                user2.setName("Elya");
                user2.setSurname("Babazade");
                user2.setAge(19);

                userRepository.save(user);
                userRepository.save(user2);
            }
        };

        return clr;
    }
}
