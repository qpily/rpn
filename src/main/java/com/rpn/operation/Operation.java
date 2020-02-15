package com.rpn.operation;

import java.util.Stack;

public interface Operation {
  String getValue();
  boolean calculate(Stack<String> stack, Stack<String> historyStack);
}
