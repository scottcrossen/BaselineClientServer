package util;

import client.ClientCommunicator;

public class StringProcessorProxy {
  private static StringProcessorProxy instance = null;

  protected StringProcessorProxy(){}

  public static StringProcessorProxy getInstance() {
    if (instance == null) {
      instance = new StringProcessorProxy();
    }
    return instance;
  }

  private ClientCommunicator clientCommunicator = new ClientCommunicator();

  public String toLowerCase(String input) throws Exception {
    return clientCommunicator.getString("/toLowerCase", input);
  }
  public String trim(String input) throws Exception {
    return clientCommunicator.getString("/trim", input);
  }
  public Integer parseInteger(String input) throws Exception {
    return clientCommunicator.getInteger("/parseInteger", input);
  }
}
