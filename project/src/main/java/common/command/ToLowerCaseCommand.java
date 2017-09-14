package common.command;

import common.util.StringProcessor;
import common.structures.Result;
import java.io.Serializable;

public class ToLowerCaseCommand extends Command implements ICommand, Serializable {

    protected CommandTypes type = CommandTypes.TOLOWERCASE;

    private String value;

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
