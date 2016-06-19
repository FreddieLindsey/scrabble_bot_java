package scrabblebot.boards;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Board {

  

  public Board() {
    if (board == null) {
      board = new scrabblebot.boards.HasbroScrabbleBoard.HasbroScrabble(boardLocation);
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
