package com.ib.strings;

import java.util.ArrayList;

public class PrettyJson {

  public ArrayList<String> prettyJSON(String A) {
    A = A.trim();
    ArrayList<String> result = new ArrayList<>();
    char[] chArr = A.trim().toCharArray();
    int whiteSpace = 0;
    String word = "";
    int len = chArr.length;
    for (int i = 0; i < len; i++) {
      char ch = chArr[i];
      if (ch == '{') {
        if (word.trim().length() > 0) {
          result.add(createNSpace(whiteSpace) + word);
          word = "";
        }
        result.add(createNSpace(whiteSpace) + ch);
        whiteSpace++;
      } else if (ch == '[') {
        if (word.trim().length() > 0) {
          result.add(createNSpace(whiteSpace) + word);
          word = "";
        }
        result.add(createNSpace(whiteSpace) + ch);
        whiteSpace++;
      } else if (ch == '}') {
        if (word.trim().length() > 0) {
          result.add(createNSpace(whiteSpace) + word);
          word = "";
        }
        whiteSpace--;
        String term = String.valueOf(ch);
        if (i < len - 1 && chArr[i + 1] == ',') {
          term += ",";
          i++;
        }
        result.add(createNSpace(whiteSpace) + term);
      } else if (ch == ']') {
        if (word.trim().length() > 0) {
          result.add(createNSpace(whiteSpace) + word);
          word = "";
        }
        whiteSpace--;
        String term = String.valueOf(ch);
        if (i < len - 1 && chArr[i + 1] == ',') {
          term += ",";
          i++;
        }
        result.add(createNSpace(whiteSpace) + term);
      } else if (ch == ',') {
        word += ch;
        if (word.trim().length() > 0) {
          result.add(createNSpace(whiteSpace) + word);
          word = "";
        }
      } else {
        word += ch;
      }
    }
    return result;
  }

  public String createNSpace(int n) {
    return new String(new char[n]).replace('\0', '\t');
  }
}
