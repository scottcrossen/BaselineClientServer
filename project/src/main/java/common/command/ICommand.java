package common.command;

import common.structures.Result;
import java.io.Serializable;

public interface ICommand {
  public CommandTypes getType();
  public Result execute();
}
