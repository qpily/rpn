package com.rpn;

import com.rpn.model.Command;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculationTest {

  private static CalculationService calculationService;

  private static Commander commander;

  @BeforeClass
  public static void init() {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    calculationService = context.getBean(CalculationService.class);
    commander = context.getBean(Commander.class);
  }

  @Test
  public void testPushNumber() {
    List<Command> commandList = commander.compile("1", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 1", calculationService.output());
    commandList = commander.compile("2 3.5", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 1 2 3.5", calculationService.output());
  }

  @Test
  public void testAddAndSubstract() {
    List<Command> commandList = commander.compile("1 2 +", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 3", calculationService.output());
    commandList = commander.compile("0.5 - 5", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 2.5 5", calculationService.output());
  }

  @Test
  public void testMultiplyAndDivide() {
    List<Command> commandList = commander.compile("2 3 *", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 6", calculationService.output());
    commandList = commander.compile("4 /", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 1.5", calculationService.output());
  }

  @Test
  public void testSqrt() {
    List<Command> commandList = commander.compile("0.5 4 sqrt", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 0.5 2", calculationService.output());
  }

  @Test
  public void testClear() {
    List<Command> commandList = commander.compile("0.777 3 -5", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 0.777 3 -5", calculationService.output());
    commandList = commander.compile("clear", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack:", calculationService.output());
  }

  @Test
  public void testUndo() {
    List<Command> commandList = commander.compile("1 2 +", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 3", calculationService.output());
    commandList = commander.compile("undo", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 1 2", calculationService.output());
    commandList = commander.compile("3 * -5", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 1 6 -5", calculationService.output());
    commandList = commander.compile("undo undo", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 1 2 3", calculationService.output());
  }

  @Test
  public void testInsucient() {
    List<Command> commandList = commander.compile("1 2 + *", false);
    calculationService.compile(commandList);
    Assert.assertEquals("stack: 3", calculationService.output());
  }
}
