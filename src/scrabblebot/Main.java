package scrabblebot;

import scrabblebot.board.Board;
import scrabblebot.board.BoardInfoException;
import scrabblebot.board.DefaultBoards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
