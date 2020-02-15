package com.rpn;

import com.rpn.model.Command;
import com.rpn.model.HistoryStack;
import com.rpn.model.NumberStack;
import com.rpn.operation.Operations;
import com.rpn.operation.Operation;
import com.rpn.utils.NumberUtils;
import com.rpn.utils.OperationValues;
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
  private HistoryStack historyStack;

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
        stack.push(commandString);
        historyStack.push(OperationValues.POP);
      } else {
        Operation operation = operations.getOperation(commandString);
        boolean succeed = operation.calculate(stack, historyStack);
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
    for (String s : stack) {
      result.append(s).append(" ");
    }
    return result.toString().trim();
  }
}
