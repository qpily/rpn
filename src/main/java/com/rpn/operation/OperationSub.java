package com.rpn.operation;

import com.rpn.model.NumberTreeNode;
import java.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationSub implements Operation {

  @Autowired
  private OperationProperties operationProperties;

  public String getValue() {
    return operationProperties.SUB;
  }

  public boolean calculate(Stack<NumberTreeNode> stack) {
    if (stack.size() < 2) {
      return false;
    }
    NumberTreeNode num2 = stack.pop();
    NumberTreeNode num1 = stack.pop();
    NumberTreeNode num = new NumberTreeNode(num1.getValue() - num2.getValue());
    num.setFirst(num1);
    num.setSecond(num2);
    stack.push(num);
    return true;
  }
}
