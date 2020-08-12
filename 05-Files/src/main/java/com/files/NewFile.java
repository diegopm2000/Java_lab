package com.files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NewFile {

  public void read() {
    try {
      String content = Files.readString(Path.of("readme.txt"));
      System.out.println(content);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void write() {
    try {
      Path path = Files.writeString(Path.of("readme.txt"), "Since JDK 11", StandardOpenOption.CREATE_NEW);
      System.out.println(path);
      String s = Files.readString(path);
      System.out.println(s);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}