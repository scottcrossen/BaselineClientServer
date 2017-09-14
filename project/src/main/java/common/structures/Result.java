package common.structures;

import java.io.Serializable;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class Result implements Serializable {
  public boolean success;

  public String data;

  public Exception error;

  public Result(boolean success, String data, Exception error) {
    this.success = success;
    this.data = data;
    this.error = error;
  }
}
