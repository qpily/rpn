package com.rpn.operation;

import com.rpn.utils.OperationValues;
import java.util.Stack;
import org.springframework.stereotype.Component;

@Component
public class OperationClear implements Operation {

  @Override
  public String getValue() {
    return OperationValues.CLEAR;
  }

  @Override
  public boolean calculate(Stack<String> stack, Stack<String> historyStack) {
    String[] numbers = stack.toArray(new String[0]);
    StringBuilder history = new StringBuilder();
    for (String number : numbers) {
      history.append(number);
      history.append(" ");
    }
    historyStack.push(history.deleteCharAt(history.length() - 1).toString());
    stack.clear();
    return true;
  }
}
