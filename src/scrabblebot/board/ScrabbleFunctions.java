package scrabblebot.board;

import scrabblebot.board.items.Letter;
import scrabblebot.board.items.Score;
import scrabblebot.board.items.Word;
import scrabblebot.utils.ScrabbleFunction;

public class ScrabbleFunctions {

  public static final ScrabbleFunction DEFAULT = new ScrabbleFunction() {
    @Override
    public Score applyToWord(Word w) {
      return w.score();
    }

    @Override
    public Score applyToLetter(Letter l) {
      return l.score();
    }

    @Override
    public boolean isWordModifier() {
      return false;
    }

    @Override
    public boolean isLetterModifier() {
      return false;
    }
  };

  public static final ScrabbleFunction DOUBLE_W = new ScrabbleFunction() {
    @Override
    public Score applyToWord(Word w) {
      return w.score().doubleScore();
    }

    @Override
    public Score applyToLetter(Letter l) {
      return l.score();
    }
  };

  public static final ScrabbleFunction TRIPLE_W = new ScrabbleFunction() {
    @Override
    public Score applyToWord(Word w) {
      return w.score().tripleScore();
    }

    @Override
    public Score applyToLetter(Letter l) {
      return l.score();
    }
  };

  public static final ScrabbleFunction DOUBLE_L = new ScrabbleFunction() {
    @Override
    public Score applyToWord(Word w) {
      return w.score();
    }

    @Override
    public Score applyToLetter(Letter l) {
      return l.score().doubleScore();
    }
  };

  public static final ScrabbleFunction TRIPLE_L = new ScrabbleFunction() {
    @Override
    public Score applyToWord(Word w) {
      return w.score();
    }

    @Override
    public Score applyToLetter(Letter l) {
      return l.score().tripleScore();
    }
  };
}
