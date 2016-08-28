package scrabblebot.utils;

import scrabblebot.board.items.Score;

public interface BoardItem {

  void validate() throws InvalidBoardItemException;

  Score getScore();

}