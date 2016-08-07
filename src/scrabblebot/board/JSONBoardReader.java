package scrabblebot.board;

import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONBoardReader {

  private final String filename;
  private JSONObject data;

  public JSONBoardReader(String filename) {
    this.filename = filename;
  }

  public JSONObject read() {
    JSONParser jsonParser = new JSONParser();

    try {
      Object o = jsonParser.parse(
        new BufferedReader(
          new FileReader(
            filename
          )
        )
      );
      data = (JSONObject) o;
    } catch (IOException e) {
      System.out.println("Error reading file " + filename + " please try again!");
    } catch (ParseException e) {
      System.out.println("Error parsing file " + filename + " please try again!");
    }

    return data;
  }
}
