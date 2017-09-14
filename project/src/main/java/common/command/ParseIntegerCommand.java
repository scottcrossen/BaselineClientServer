package common.command;

import common.util.StringProcessor;
import common.structures.Result;
import java.io.Serializable;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class ParseIntegerCommand implements ICommand, Serializable {

  public static CommandTypes type = CommandTypes.PARSE_INT;
  private String value;

  public CommandTypes getType() {
    return type;
  }

  public ParseIntegerCommand(String value) {
    this.value = value;
  }

  public Result execute() {
    try {
      String result = Integer.toString(StringProcessor.getInstance().parseInteger(value));
      return new Result(true, result, null);
    } catch (Exception e) {
      return new Result(true, null, e);
    }
  }
}
