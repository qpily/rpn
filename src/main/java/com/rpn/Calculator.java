package com.rpn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Calculator {
  public static void main(String... args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    CalculationService calculationService = context.getBean(CalculationService.class);
    calculationService.start();
  }
}
