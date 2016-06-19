package scrabblebot.boards;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class HasbroScrabbleBoard {

  private final static String boardLocation = "lib/board_configs/hasbro_scrabble.json";
  private static HasbroScrabble board;

  public HasbroScrabbleBoard() {
    if (board == null) {
      board = new HasbroScrabble(boardLocation);
    }
  }

  private class HasbroScrabble {
    public HasbroScrabble(String board) {
      try {
        BufferedReader reader =
          new BufferedReader(
            new FileReader(board));
        JSONParser parser = new JSONParser();
        JSONObject o = (JSONObject) parser.parse(reader);
      } catch (FileNotFoundException e) {
        System.out.println("Could not read board, does the board live at " + boardLocation);
        e.printStackTrace();
      } catch (ParseException e) {
        System.out.println("Could not parse board, please contact developer");
        e.printStackTrace();
      } catch (IOException e) {
        System.out.println("Could not read board, there was an IO Exception");
        e.printStackTrace();
      }
    }
  }
}
