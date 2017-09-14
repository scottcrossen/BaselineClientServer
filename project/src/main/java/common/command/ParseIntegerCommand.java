package common.command;

import common.util.StringProcessor;
import common.structures.Result;
import java.io.Serializable;

public class ParseIntegerCommand extends Command implements ICommand {

    protected CommandTypes type = CommandTypes.PARSEINTEGER;

    private String value;

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
