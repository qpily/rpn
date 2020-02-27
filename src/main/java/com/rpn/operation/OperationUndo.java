package com.rpn.operation;

import com.rpn.model.NumberTreeNode;
import java.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationUndo implements Operation {

  @Autowired
  private OperationProperties operationProperties;

  public String getValue() {
    return operationProperties.UNDO;
  }

  @Override
  public boolean calculate(Stack<NumberTreeNode> stack) {
    if (stack.size() <= 0) {
      return false;
    }
    NumberTreeNode num = stack.pop();
    if (num.getFirst() != null) {
      stack.push(num.getFirst());
    }
    if (num.getSecond() != null) {
      stack.push(num.getSecond());
    }
    return true;
  }
}
