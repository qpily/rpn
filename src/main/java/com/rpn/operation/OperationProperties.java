package com.rpn.operation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class OperationProperties {
  @Value("${operation.value.add}")
  public String ADD;
  @Value("${operation.value.sub}")
  public String SUB;
  @Value("${operation.value.multiply}")
  public String MULTIPLY;
  @Value("${operation.value.divide}")
  public String DIVIDE;
  @Value("${operation.value.sqrt}")
  public String SQRT;
  @Value("${operation.value.clear}")
  public String CLEAR = "clear";
  @Value("${operation.value.undo}")
  public String UNDO = "undo";
  @Value("${operation.value.quit}")
  public String QUIT = "quit";
}
