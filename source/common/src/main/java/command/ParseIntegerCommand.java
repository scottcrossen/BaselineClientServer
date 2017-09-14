package command;

import util.StringProcessor;

public class ParseIntegerCommand implements Command {

    protected CommandTypes type = CommandTypes.PARSEINTEGER;

    private String value;

    public ParseIntegerCommand(String value) {
      this.value = value;
    }

    public Results execute() {
      try {
        String result = Integer.toString(StringProcessor.getInstance().parseInteger(value));
        return new Results(true, result, "");
      } catch (Exception e) {
        return new Results(true, "", e.getMessage());
      }
    }
}
