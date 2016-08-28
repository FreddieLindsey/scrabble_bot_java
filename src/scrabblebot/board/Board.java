package scrabblebot.board;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import scrabblebot.board.items.BoardMarker;
import scrabblebot.board.items.Modifier;
import scrabblebot.utils.ScrabbleFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

  private final BoardMarker[][] boardMarkers;
  private final String name;
  private final Long width;
  private final Long height;
  private final HashMap<Character, Integer> character_scoring;
  private final Long tilesTotal;
  private final Long tilesEach;

  private final JSONObject boardInfo;

  public Board(JSONObject boardInfo) throws BoardInfoException {
    this.boardInfo = boardInfo;
    validateBoardInformation();

    // Entries in map
    JSONObject tiles = ((JSONObject) boardInfo.get("tiles"));
    JSONObject scores = ((JSONObject) boardInfo.get("scores"));

    this.name = (String) boardInfo.get("board_name");
    this.width = (Long) boardInfo.get("board_width");
    this.height = (Long) boardInfo.get("board_height");
    this.boardMarkers = new BoardMarker[ width.intValue() ][ height.intValue() ];

    this.tilesTotal = (Long) tiles.get("total");
    this.tilesEach = (Long) tiles.get("each");

    this.character_scoring = new HashMap<>();

    for (char c = 'a'; c <= 'z'; c++) {
      this.character_scoring.put(c, ((Long) scores.get(String.valueOf(c))).intValue());
    }

    generateBoard();
  }

  private void validateBoardInformation() throws BoardInfoException {
    String[] properties = new String[]{
      "board_name", "board_width", "board_height", "tiles"
    };

    for (String p : properties) {
      if (!boardInfo.containsKey(p)) {
        throw new BoardInfoException(
          "Board at " + boardInfo.get("filename") + " does not contain key:\t" + p
        );
      }
    }
  }

  private void generateBoard() {
    // Initialise board markers
    for (int i = 0; i < boardMarkers.length; i++) {
      for (int j = 0; j < boardMarkers.length; j++) {
        boardMarkers[i][j] = new BoardMarker();
      }
    }

    // Apply modifiers to board markers
    JSONObject modifiers = (JSONObject) boardInfo.get("modifiers");
    if (modifiers != null) {
      for (Object item : modifiers.entrySet()) {
        Map.Entry<String, JSONArray> kv = (Map.Entry<String, JSONArray>) item;

        String type = kv.getKey();
        ScrabbleFunction f = ScrabbleFunctions.DEFAULT;
        switch (type) {
          case "double_w":
            f = ScrabbleFunctions.DOUBLE_W;
            break;

          case "triple_w":
            f = ScrabbleFunctions.TRIPLE_W;
            break;

          case "double_l":
            f = ScrabbleFunctions.DOUBLE_L;
            break;

          case "triple_l":
            f = ScrabbleFunctions.TRIPLE_L;
            break;
        }
        Modifier m = new Modifier(type, f);

        for (Object o : kv.getValue()) {
          JSONObject coords = (JSONObject) o;
          Long x = (Long) coords.get("x");
          Long y = (Long) coords.get("y");
          boardMarkers[ x.intValue() - 1 ][ y.intValue() - 1 ].applyModifier(m);
        }
      }
    }
  }

}
