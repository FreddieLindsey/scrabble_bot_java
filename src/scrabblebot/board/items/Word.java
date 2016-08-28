package scrabblebot.board.items;

import scrabblebot.utils.BoardItem;
import scrabblebot.utils.InvalidBoardItemException;

import java.util.ArrayList;
import java.util.List;

public class Word implements BoardItem {

  private final ArrayList<BoardMarker> word;

  public Word() {
    this.word = new ArrayList<>();
  }

  public Word(String s) {
    this();
    for (Character c : s.toCharArray()) {
      BoardMarker bm = new BoardMarker();
      bm.setLetter(c);
      word.add(bm);
    }
  }

  @Override
  public void validate() throws InvalidBoardItemException {
    // Check length at least 2
    if (word.size() < 2)
      throw new InvalidBoardItemException("Word must be at least 2 letters long.");
  }

  @Override
  public Score getScore() {
    Score s = new Score();

    List<Modifier> mods = new ArrayList<>();
    for (BoardMarker bm : word) {
      Score bms = bm.getScore();
      if (bm.hasModifier())
        mods.add(bm.getModifier());

      s.mergeScore(bms);
    }

    for (Modifier m : mods) {
      if
    }

    return s;
  }
}