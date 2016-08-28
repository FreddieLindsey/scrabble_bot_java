package scrabblebot.board.items;

import scrabblebot.utils.InvalidBoardItemException;

public class BoardMarker {

  private Modifier modifier;
  private Letter l;

  public void applyModifier(Modifier m) {
    modifier = m;
  }

  public void setLetter(Character c) {
    try {
      l = new Letter(c);
      l.validate();
    } catch (InvalidBoardItemException e) {
      Sys
    }
  }

  public Score getScore() {
    Score s = l.getScore();
  }

  public boolean hasModifier() {
    return modifier != null;
  }

  public Modifier getModifier() {
    return modifier;
  }
}
