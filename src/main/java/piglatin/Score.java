package piglatin;

class Score {
  private int sum = 0;

  Score() {}

  /**
    Scores a string.
    Returns the single score but also sums up internally.
    @see getScore
  */
  public int score(final String solution, final String answer) {
    int v = solution.equals(answer) ? 1 : 0;
    sum += v;
    return v;
  }

 
  /**
    Get accumulated score
  */ 
  public int getScore() {
    return sum;
  }
}
