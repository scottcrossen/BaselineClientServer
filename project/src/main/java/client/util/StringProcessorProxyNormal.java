package client.util;

import client.communicator.ClientCommunicator;
import common.structures.Result;

public class StringProcessorProxyNormal {
  private static StringProcessorProxyNormal instance = null;

  protected StringProcessorProxyNormal(){}

  public static StringProcessorProxyNormal getInstance() {
    if (instance == null) {
      instance = new StringProcessorProxyNormal();
    }
    return instance;
  }

  private ClientCommunicator clientCommunicator = new ClientCommunicator();

  public String toLowerCase(String input) throws Exception {
    Result result = clientCommunicator.post("/toLowerCase", input);
    if (result.success) {
      return result.data;
    } else {
      throw result.error;
    }
  }

  public String trim(String input) throws Exception {
    Result result = clientCommunicator.post("/trim", input);
    if (result.success) {
      return result.data;
    } else {
      throw result.error;
    }
  }

  public Integer parseInteger(String input) throws Exception {
    Result result = clientCommunicator.post("/parseInteger", input);
    if (result.success) {
      return Integer.parseInt(result.data);
    } else {
      throw result.error;
    }
  }
}
