package command;

import util.StringProcessor;

public class ToLowerCaseCommand implements Command {

    protected CommandTypes type = CommandTypes.TOLOWERCASE;

    private String value;

    public ToLowerCaseCommand(String value) {
      this.value = value;
    }

    public Results execute() {
      try {
        String result = StringProcessor.getInstance().toLowerCase(value);
        return new Results(true, result, "");
      } catch (Exception e) {
        return new Results(true, "", e.getMessage());
      }
    }
}
