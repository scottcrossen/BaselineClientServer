package common.structures;

import java.io.Serializable;

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
