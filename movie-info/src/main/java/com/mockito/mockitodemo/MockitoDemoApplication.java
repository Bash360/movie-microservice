package com.mockito.mockitodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MockitoDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MockitoDemoApplication.class, args);
  }
}
