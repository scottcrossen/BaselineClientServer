package common.command;

import common.structures.Result;
import java.io.Serializable;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public interface ICommand {
  public CommandTypes getType();
  public Result execute();
}
