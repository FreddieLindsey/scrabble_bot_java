package scrabblebot.board.items;

import scrabblebot.utils.ScrabbleFunction;

public class Modifier {

  private final String name;
  private final ScrabbleFunction function;

  public Modifier(String name, ScrabbleFunction function) {
    this.name = name;
    this.function = function;
  }

}
