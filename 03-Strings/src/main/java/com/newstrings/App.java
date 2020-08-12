package com.newstrings;

import java.util.stream.Collectors;

public class App 
{
    public void isBlank(String text) {
      System.out.println(text.isBlank());
    }

    public void repeat(String text, int number) {
      var repeatedText = text.repeat(number);
      System.out.println(repeatedText);
    }

    public void toList(String text) {
      System.out.println(text.lines().collect(Collectors.toList()));
    }

    // Remove blank spaces. strip can remove the unicode characters like \u2005 (blank space in unicode format)
    public void removeBlankSpaces(String text) {
      System.out.println("<" + text.strip() + ">");
      System.out.println("<" + text.stripLeading() + ">");
      System.out.println("<" + text.stripTrailing() +">");
      System.out.println("<" + text.trim() + ">");
    }

    public static void main( String[] args )
    {
        App app = new App();
        app.isBlank(" ");
        app.repeat("java", 5);
        app.toList("java c python javascript rust");
        app.removeBlankSpaces(" sample text\u2005 ");
    }
}
