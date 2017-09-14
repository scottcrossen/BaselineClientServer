package common.command;

import common.structures.Result;
import java.io.Serializable;

public interface ICommand {
  public CommandTypes type = CommandTypes.NONE;
  public Result execute();
}
