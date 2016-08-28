package scrabblebot.board.items;

import scrabblebot.utils.BoardItem;
import scrabblebot.utils.InvalidBoardItemException;

public class Letter implements BoardItem {

  private final Character c;

  public Letter(Character c) {
    this.c = c;
  }

  @Override
  public void validate() throws InvalidBoardItemException {
    // Validate letter is within acceptable range
    if (!( c >= 'a' && c <= 'z' ||
           c >= 'A' && c <= 'Z' ))
      throw new InvalidBoardItemException("Character is not in allowed range: [a-zA-Z]");
  }

  @Override
  public Score score() {
    return new Score().add(1);
  }
}
