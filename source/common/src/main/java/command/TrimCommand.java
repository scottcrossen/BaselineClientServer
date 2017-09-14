package command;

import util.StringProcessor;

public class TrimCommand implements Command {

    protected CommandTypes type = CommandTypes.TRIM;

    private String value;

    public TrimCommand(String value) {
      this.value = value;
    }

    public Results execute() {
      try {
        String result = StringProcessor.getInstance().trim(value);
        return new Results(true, result, "");
      } catch (Exception e) {
        return new Results(true, "", e.getMessage());
      }
    }
}
