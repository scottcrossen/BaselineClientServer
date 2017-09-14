package client.main;

import client.util.StringProcessorProxyNormal;
import client.util.StringProcessorProxyCommand;
import java.util.concurrent.TimeUnit;

public class Main {

  private static StringProcessorProxyNormal stringProcessorProxyNormal = StringProcessorProxyNormal.getInstance();
  private static StringProcessorProxyCommand stringProcessorProxyCommand = StringProcessorProxyCommand.getInstance();

  public static void main(String[] args) {
    boolean fail = false;
    while (!fail) {
      System.out.println("===================================");
      System.out.println("Client monitor calling test methods");
      String testString;

      testString = "BYU_CS_340";
      System.out.println("Testing normal method \'toLowerCase\' on string \'" + testString + "\'");
      try {
        System.out.println("Output: \'" + stringProcessorProxyNormal.toLowerCase(testString) + "\'");
  		} catch (Exception e) {
  			System.out.println("Error: " + e.getMessage());
  		}
      System.out.println("Testing command method \'toLowerCase\' on string \'" + testString + "\'");
      try {
        System.out.println("Output: \'" + stringProcessorProxyCommand.toLowerCase(testString) + "\'");
  		} catch (Exception e) {
  			System.out.println("Error: " + e.getMessage());
  		}

      testString = "  BYU_CS_340  ";
      System.out.println("Testing normal method \'trim\' on string \'" + testString + "\'");
      try {
        System.out.println("Output: \'" + stringProcessorProxyNormal.trim(testString) + "\'");
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
      System.out.println("Testing command method \'trim\' on string \'" + testString + "\'");
      try {
        System.out.println("Output: \'" + stringProcessorProxyCommand.trim(testString) + "\'");
  		} catch (Exception e) {
  			System.out.println("Error: " + e.getMessage());
  		}

      testString = "340";
      System.out.println("Testing normal method \'parseInteger\' on string \'" + testString + "\'");
      try {
        System.out.println("Output: \'" + stringProcessorProxyNormal.parseInteger(testString) + "\'");
      } catch (Exception e) {
        System.out.println("Error: " + e.toString());
      }
      System.out.println("Testing command method \'parseInteger\' on string \'" + testString + "\'");
      try {
        System.out.println("Output: \'" + stringProcessorProxyCommand.parseInteger(testString) + "\'");
  		} catch (Exception e) {
  			System.out.println("Error: " + e.getMessage());
  		}

      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (Exception b) {
        fail = true;
      }
    }
  }
}
