package com.scottcrossen42.stringprocessor.common.util;

import com.scottcrossen42.stringprocessor.common.structures.Result;
import com.scottcrossen42.stringprocessor.common.command.ICommand;
import java.io.*;

/**
* @author Scott Leland Crossen
* @Copyright 2017 Scott Leland Crossen
*/
public class Serializer {
  private static Serializer instance = null;

  protected Serializer(){}

  public static Serializer getInstance() {
    if (instance == null) {
      instance = new Serializer();
    }
    return instance;
  }

  public static void write(OutputStream os, Serializable object) throws IOException {
    ObjectOutputStream out = new ObjectOutputStream(os);
    out.writeObject(object);
    out.flush();
  }

  public static ICommand readCommand(InputStream is) throws IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(is);
    ICommand object = (ICommand) in.readObject();
    in.close();
    return object;
  }

  public static String readString(InputStream is) throws IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(is);
    String object = (String) in.readObject();
    in.close();
    return object;
  }

  public static Integer readInteger(InputStream is) throws IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(is);
    Integer object = (Integer) in.readObject();
    in.close();
    return object;
  }

  public static Result readResult(InputStream is) throws IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(is);
    Result object = (Result) in.readObject();
    in.close();
    return object;
  }
}
