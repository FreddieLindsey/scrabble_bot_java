package scrabblebot.board;

import com.oracle.javafx.jmx.json.JSONDocument;
import com.oracle.javafx.jmx.json.JSONReader;
import org.json.simple.JSONObject;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public enum DefaultBoards {

  HASBROSCRABBLE,
  WORDSWITHFRIENDS;

  public static Board newBoard(DefaultBoards boardName) throws IllegalArgumentException, BoardInfoException {
    JSONBoardReader jsonBoardReader;
    String inputFile;

    switch(boardName) {
      case HASBROSCRABBLE:
        inputFile = "/Volumes/git/personal/scrabble_bot_java/board_configs/hasbro_scrabble.json";
        jsonBoardReader = new JSONBoardReader(inputFile);
        break;
      case WORDSWITHFRIENDS:
        inputFile = "/Volumes/git/personal/scrabble_bot_java/board_configs/words_with_friends.json";
        jsonBoardReader = new JSONBoardReader(inputFile);
        break;
      default:
        throw new IllegalArgumentException("You have supplied a board name that is unsupported. Please seek support.");
    }

    JSONObject boardInfo = jsonBoardReader.read();

    return new Board(boardInfo);
  }

}
