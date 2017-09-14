package command;

public class Results {
  public boolean success;

  public String data;

  public String errorInfo;

  public Results(boolean success, String data, String errorInfo) {
    this.success = success;
    this.data = data;
    this.errorInfo = errorInfo;
  }
}
