package com.rpn.operation;

import com.rpn.utils.NumberUtils;
import com.rpn.utils.OperationValues;
import java.util.Stack;
import org.springframework.stereotype.Component;

@Component
public class OperationDivide implements Operation {

  @Override
  public String getValue() {
    return OperationValues.DIVIDE;
  }

  @Override
  public boolean calculate(Stack<String> stack, Stack<String> historyStack) {
    if (stack.size() < 2) {
      return false;
    }
    double num2 = Double.parseDouble(stack.pop());
    double num1 = Double.parseDouble(stack.pop());
    double num = num1 / num2;
    stack.push(NumberUtils.numberToString(num));
    historyStack.push(NumberUtils.generateHistoryString(num1, num2));
    return true;
  }
}
