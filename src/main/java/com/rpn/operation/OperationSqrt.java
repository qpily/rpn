package com.rpn.operation;

import com.rpn.model.NumberTreeNode;
import java.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationSqrt implements Operation {

  @Autowired
  private OperationProperties operationProperties;

  public String getValue() {
    return operationProperties.SQRT;
  }

  @Override
  public boolean calculate(Stack<NumberTreeNode> stack) {
    if (stack.size() < 1) {
      return false;
    }
    NumberTreeNode num1 = stack.pop();
    NumberTreeNode num = new NumberTreeNode(Math.sqrt(num1.getValue()));
    num.setFirst(num1);
    stack.push(num);
    return true;
  }
}
