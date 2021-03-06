package com.rpn.operation;

import com.rpn.model.NumberTreeNode;
import java.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationClear implements Operation {

  @Autowired
  private OperationProperties operationProperties;

  public String getValue() {
    return operationProperties.CLEAR;
  }

  @Override
  public boolean calculate(Stack<NumberTreeNode> stack) {
    stack.clear();
    return true;
  }
}
