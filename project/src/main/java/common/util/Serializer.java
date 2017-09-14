package common.util;

import common.structures.Result;
import common.command.Command;
import java.io.*;

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

  public static Command readCommand(InputStream is) throws IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(is);
    Command object = (Command) in.readObject();
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
