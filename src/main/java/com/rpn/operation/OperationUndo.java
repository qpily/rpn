package com.rpn.operation;

import com.rpn.utils.OperationValues;
import java.util.Stack;
import org.springframework.stereotype.Component;

@Component
public class OperationUndo implements Operation {

  @Override
  public String getValue() {
    return OperationValues.UNDO;
  }

  @Override
  public boolean calculate(Stack<String> stack, Stack<String> historyStack) {
    if (historyStack.size() <= 0) {
      return false;
    }
    String history = historyStack.pop();
    String[] commands = history.split(" ");
    for (String command : commands) {
      if (command.equalsIgnoreCase(OperationValues.POP)) {
        stack.pop();
      } else {
        stack.push(command);
      }
    }
    return true;
  }
}
