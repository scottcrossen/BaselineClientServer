package main;

import util.StringProcessorProxy;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
      boolean fail = false;
      while (!fail) {
          System.out.println("===================================");
          System.out.println("Client monitor calling test methods");
          String testString;
          StringProcessorProxy stringProcessorProxy = StringProcessorProxy.getInstance();
          testString = "BYU_CS_340";
          System.out.println("Testing method \'toLowerCase\' on string \'" + testString + "\'");
          try {
            System.out.println("Output: \'" + stringProcessorProxy.toLowerCase(testString) + "\'");
      		} catch (Exception e) {
      			System.out.println("Error: " + e.getMessage());
      		}
          testString = "  BYU_CS_340  ";
          System.out.println("Testing method \'trim\' on string \'" + testString + "\'");
          try {
            System.out.println("Output: \'" + stringProcessorProxy.trim(testString) + "\'");
          } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
          }
          testString = "340";
          System.out.println("Testing method \'parseInteger\' on string \'" + testString + "\'");
          try {
            System.out.println("Output: \'" + stringProcessorProxy.parseInteger(testString) + "\'");
          } catch (Exception e) {
            System.out.println("Error: " + e.toString());
          }
          try {
            TimeUnit.SECONDS.sleep(5);
          } catch (Exception b) {
            fail = true;
        }
      }
    }
}
