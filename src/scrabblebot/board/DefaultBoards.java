package scrabblebot.board;

import org.json.simple.JSONObject;

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
