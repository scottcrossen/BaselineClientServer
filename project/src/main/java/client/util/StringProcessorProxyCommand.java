package client.util;

import client.communicator.ClientCommunicator;
import common.structures.Result;
import common.command.*;

public class StringProcessorProxyCommand {
  private static StringProcessorProxyCommand instance = null;

  protected StringProcessorProxyCommand(){}

  public static StringProcessorProxyCommand getInstance() {
    if (instance == null) {
      instance = new StringProcessorProxyCommand();
    }
    return instance;
  }

  private ClientCommunicator clientCommunicator = new ClientCommunicator();

  public String toLowerCase(String input) throws Exception {
    Result result = clientCommunicator.post("/execCommand", new ToLowerCaseCommand(input));
    if (result.success) {
      return result.data;
    } else {
      throw result.error;
    }
  }
  
  public String trim(String input) throws Exception {
    Result result = clientCommunicator.post("/execCommand", new TrimCommand(input));
    if (result.success) {
      return result.data;
    } else {
      throw result.error;
    }
  }

  public Integer parseInteger(String input) throws Exception {
    Result result = clientCommunicator.post("/execCommand", new ParseIntegerCommand(input));
    if (result.success) {
      return Integer.parseInt(result.data);
    } else {
      throw result.error;
    }
  }
}
