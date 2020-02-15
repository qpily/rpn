package com.rpn.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import com.rpn.operation.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Operations {

  @Autowired
  private List<Operation> operations;

  private final Map<String, Operation> operationMap = new HashMap<String, Operation>();

  @PostConstruct
  private void initOperations() {
    for (Operation operation : operations) {
      operationMap.put(operation.getValue(), operation);
    }
  }

  public Operation getOperation(String command) {
    return operationMap.get(command);
  }

  public boolean contains(String command) {
    return operationMap.containsKey(command);
  }
}
