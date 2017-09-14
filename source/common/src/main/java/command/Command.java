package command;

public interface Command {
  public CommandTypes type = CommandTypes.NONE;
  public Results execute();
}
