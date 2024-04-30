package am.cs322;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"am.cs322"})
public class Cs322Homework2Application {

    public static void main(String[] args) {

        System.setProperty("server.port", "8082");

        SpringApplication.run(Cs322Homework2Application.class, args);
    }
}