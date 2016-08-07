package scrabblebot;

import scrabblebot.board.Board;
import scrabblebot.board.BoardInfoException;
import scrabblebot.board.DefaultBoards;

public class Main {

  public static void main(String[] args) {
    try {
      Board b = DefaultBoards.newBoard(DefaultBoards.WORDSWITHFRIENDS);
    } catch (BoardInfoException e) {
      System.err.println(e.toString());
      System.exit(2);
    }
  }

}
