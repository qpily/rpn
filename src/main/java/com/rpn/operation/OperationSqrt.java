package com.rpn.operation;

import com.rpn.utils.NumberUtils;
import com.rpn.utils.OperationValues;
import java.util.Stack;
import org.springframework.stereotype.Component;

@Component
public class OperationSqrt implements Operation {

  @Override
  public String getValue() {
    return OperationValues.SQRT;
  }

  @Override
  public boolean calculate(Stack<String> stack, Stack<String> historyStack) {
    if (stack.size() < 1) {
      return false;
    }
    double num1 = Double.parseDouble(stack.pop());
    double num = Math.sqrt(num1);
    stack.push(NumberUtils.numberToString(num));
    historyStack.push(NumberUtils.generateHistoryString(num1));
    return true;
  }
}
