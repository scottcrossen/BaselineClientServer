package com.scottcrossen42.stringprocessor.common.util;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class StringProcessor {
  private static StringProcessor instance = null;

  protected StringProcessor(){}

  public static StringProcessor getInstance() {
    if (instance == null) {
      instance = new StringProcessor();
    }
    return instance;
  }

  public String toLowerCase(String input) {
    return input.toLowerCase();
  }

  public String trim(String input) {
    return input.trim();
  }

  public Integer parseInteger(String input) {
    return Integer.parseInt(input);
  }
}
