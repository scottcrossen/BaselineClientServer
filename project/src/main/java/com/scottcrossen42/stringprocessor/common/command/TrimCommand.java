package com.scottcrossen42.stringprocessor.common.command;

import com.scottcrossen42.stringprocessor.common.util.StringProcessor;
import com.scottcrossen42.stringprocessor.common.structures.Result;
import java.io.Serializable;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
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
