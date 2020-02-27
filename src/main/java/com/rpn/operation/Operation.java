package com.rpn.operation;

import com.rpn.model.NumberTreeNode;
import java.util.Stack;

public interface Operation {
  String getValue();
  boolean calculate(Stack<NumberTreeNode> stack);
}
