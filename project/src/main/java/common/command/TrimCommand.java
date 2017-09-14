package common.command;

import common.util.StringProcessor;
import common.structures.Result;
import java.io.Serializable;

public class TrimCommand implements ICommand, Serializable {

  public static CommandTypes type = CommandTypes.TRIM;
  private String value;

  public CommandTypes getType() {
    return type;
  }

  public TrimCommand(String value) {
    this.value = value;
  }

  public Result execute() {
    try {
      String result = StringProcessor.getInstance().trim(value);
      return new Result(true, result, null);
    } catch (Exception e) {
      return new Result(true, null, e);
    }
  }
}
