package scrabblebot.board.items;

public class Score {

  private int score;

  public Score() {
    this.score = 0;
  }

  public Score add(int score) throws IllegalArgumentException {
    // No negative scores allowed
    if (score < 0)
      throw new IllegalArgumentException("No score is negative!");

    this.score += score;
    return this;
  }

  public Score doubleScore() {
    this.score *= 2;
    return this;
  }

  public Score tripleScore() {
    this.score *= 3;
    return this;
  }

  public void mergeScore(Score other) {
    this.score += other.score;
  }
}
