package finki.ukim.mk.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {

        return new BCryptPasswordEncoder(10);
    }
}
