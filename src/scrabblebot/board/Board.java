package scrabblebot.board;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;

public class Board {

  private final BoardMarker[][] boardMarkers;
  private final String name;
  private final Long width;
  private final Long height;
  private final HashMap<Character, Integer> character_scoring;
  private final JSONObject boardInfo;

  public Board(JSONObject boardInfo) throws BoardInfoException {
    this.boardInfo = boardInfo;
    validateBoardInformation();

    this.name = (String) boardInfo.get("board_name");
    this.width = (Long) boardInfo.get("board_width");
    this.height = (Long) boardInfo.get("board_height");
    this.boardMarkers = new BoardMarker[width.intValue()][height.intValue()];
    this.character_scoring = new HashMap<>();

    generateBoard();
  }

  private void validateBoardInformation() throws BoardInfoException {
    String[] properties = new String[]{
      "board_name", "board_width", "board_height"
    };

    for (String p : properties) {
      if (!boardInfo.containsKey(p)) {
        throw new BoardInfoException(
          "Board at " + boardInfo.get("filename") + " does not contain key:\t" + p
        );
      }
    }
  }

  private void applyModifiers(List<Modifier> modifiers) {
    System.out.println("TODO: Applying modifiers");
  }

  private void generateBoard() {
    for (int i = 0; i < boardMarkers.length; i++) {
      for (int j = 0; j < boardMarkers.length; j++) {
        boardMarkers[i][j] = new BoardMarker();
      }
    }
  }

}
