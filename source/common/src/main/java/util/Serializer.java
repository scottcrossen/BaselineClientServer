package util;

public class Serializer {
  private static Serializer instance = null;

  protected Serializer(){}

  public static Serializer getInstance() {
    if (instance == null) {
      instance = new Serializer();
    }
    return instance;
  }

  public String serializeResult(Result result) {
  }
  public Command deserializeCommand(String serial) {
  }
}
