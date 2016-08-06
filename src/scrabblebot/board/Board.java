package scrabblebot.board;

import java.util.HashMap;

public class Board {

  private final BoardMarker[][] boardMarkers;
  private final String name;
  private final int width;
  private final int height;
  private final HashMap<Character, Integer> character_scoring;

  public Board(String name, int width, int height) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.boardMarkers = new BoardMarker[width][height];
    this.character_scoring = new HashMap<>();

    generateBoard();
  }

  private void generateBoard() {
    for (int i = 0; i < boardMarkers.length; i++) {
      for (int j = 0; j < boardMarkers.length; j++) {
        
      }
    }
  }

}
