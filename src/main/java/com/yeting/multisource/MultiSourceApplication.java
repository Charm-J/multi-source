package com.yeting.multisource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MultiSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiSourceApplication.class, args);
    }

}
