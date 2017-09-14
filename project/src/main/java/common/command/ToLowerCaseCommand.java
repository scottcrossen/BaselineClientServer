package common.command;

import common.util.StringProcessor;
import common.structures.Result;
import java.io.Serializable;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class ToLowerCaseCommand implements ICommand, Serializable {

  public static CommandTypes type = CommandTypes.TO_LOWER_CASE;
  private String value;

  public CommandTypes getType() {
    return type;
  }

  public ToLowerCaseCommand(String value) {
    this.value = value;
  }

  public Result execute() {
    try {
      String result = StringProcessor.getInstance().toLowerCase(value);
      return new Result(true, result, null);
    } catch (Exception e) {
      return new Result(true, null, e);
    }
  }
}
