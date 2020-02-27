package com.rpn;

import com.rpn.model.Command;
import com.rpn.operation.OperationProperties;
import com.rpn.utils.NumberUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.rpn.operation.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Commander {

  private Scanner scanner = new Scanner(System.in);

  private final Operations operations;

  @Autowired
  private OperationProperties operationProperties;

  @Autowired
  public Commander(Operations operations) {
    this.operations = operations;
  }

  public List<Command> read() {
    String line = scanner.nextLine();
    return compile(line);
  }

  public List<Command> compile(String line) {
    if (!line.equalsIgnoreCase(operationProperties.QUIT)) {
      List<Command> list = new ArrayList<>();
      char[] chars = (line.trim() + " ").toCharArray();
      int start = 1;
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == ' ') {
          String commandString = stringBuilder.toString();
          if (!NumberUtils.isNumber(commandString) && (!operations
              .contains(commandString.toLowerCase()))) {
            System.out.println("error command (position: " + start + "): " + commandString);
            return list;
          } else {
            Command command = new Command();
            command.setCommand(commandString);
            command.setPosition(start);
            list.add(command);
            start = i + 2;
            stringBuilder = new StringBuilder();
          }
        } else {
          stringBuilder.append(chars[i]);
        }
      }
      return list;
    } else {
      return null;
    }
  }
}
