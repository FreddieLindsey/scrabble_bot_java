package scrabblebot.utils;

import scrabblebot.board.items.Letter;
import scrabblebot.board.items.Word;
import scrabblebot.board.items.Score;

public interface ScrabbleFunction {

  Score applyToWord(Word w);

  Score applyToLetter(Letter l);

  boolean isWordModifier();

  boolean isLetterModifier();

}