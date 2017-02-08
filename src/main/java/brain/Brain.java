package brain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Brain {

    public static void main(final String[] args) {

        SpringApplication.run(Brain.class, args);

        System.out.println("Brain is listening.");
    }

}
