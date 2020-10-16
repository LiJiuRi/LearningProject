package com.example.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ServletComponentScan(basePackages = {"com.example.transaction.filter"})
public class TransactionLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionLearnApplication.class, args);
    }

}
