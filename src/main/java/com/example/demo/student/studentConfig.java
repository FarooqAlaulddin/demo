package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return args -> {
            student farooq = new student(
                    "Farooq",
                    "farooq@gmail.com",
                    LocalDate.of(1990, Month.AUGUST,5)
            );

            student lobna = new student(
                    "Lobna",
                    "lobna@gmail.com",
                    LocalDate.of(1995, Month.AUGUST,5)
            );

            repository.saveAll(List.of(farooq, lobna));

        };
    }
}
