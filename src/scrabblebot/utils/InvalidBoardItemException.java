package scrabblebot.utils;

public class InvalidBoardItemException extends Exception {

  public InvalidBoardItemException(String error) {
    super(error);
  }
}
