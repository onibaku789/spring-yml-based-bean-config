package org.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StringManipulationService stringManipulationService) {
        return (args) -> {
            // Example usage of the StringManipulationService
            String inputString = "Hello, World-";
            System.out.println("Original: " + inputString);
            String processedString = stringManipulationService.processString(inputString);
            System.out.println("Processed: " + processedString);
        };
    }
}
