package com.rpn;

import com.rpn.model.Command;
import java.util.List;

public interface CalculationService {
  void start();
  void compile(List<Command> commands);
  String output();
}
