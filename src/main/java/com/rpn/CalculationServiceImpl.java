package com.rpn;

import com.rpn.model.Command;
import com.rpn.model.NumberStack;
import com.rpn.model.NumberTreeNode;
import com.rpn.operation.Operations;
import com.rpn.operation.Operation;
import com.rpn.utils.NumberUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

  @Autowired
  private Commander commander;
  @Autowired
  private Operations operations;
  @Autowired
  private NumberStack stack;

  @Autowired
  public CalculationServiceImpl() {}

  public void start() {
    while (true) {
      List<Command> commands = commander.read();
      if (commands == null) {
        break;
      }
      compile(commands);
      System.out.println(output());
    }
  }

  @Override
  public void compile(List<Command> commands) {
    for (Command command : commands) {
      String commandString = command.getCommand();
      if (NumberUtils.isNumber(commandString)) {
        stack.push(new NumberTreeNode(Double.parseDouble(commandString)));
      } else {
        Operation operation = operations.getOperation(commandString);
        boolean succeed = operation.calculate(stack);
        if (!succeed) {
          System.out.println("operator " + commandString + " (position: " + command.getPosition()
              + "): insucient parameters");
          break;
        }
      }
    }
  }

  @Override
  public String output() {
    StringBuilder result = new StringBuilder();
    result.append("stack: ");
    for (NumberTreeNode n : stack) {
      result.append(NumberUtils.numberToString(n.getValue())).append(" ");
    }
    return result.toString().trim();
  }
}
