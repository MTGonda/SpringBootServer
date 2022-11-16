package maciej.gonda.springbootserver;

import maciej.gonda.springbootserver.entities.User;
import maciej.gonda.springbootserver.repositories.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServerApplication.class, args);

    }
    @Bean
    CommandLineRunner run(UserRepo userRepo){
        return args->{
            userRepo.save(new User(null,"test","test",null,null,null));
            System.out.println("test");
        };
    }



}
