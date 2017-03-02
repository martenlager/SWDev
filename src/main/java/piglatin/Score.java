package piglatin;

class Score {
  Score() {}

  public int score(final String solution, final String answer) {
    return solution.equals(answer) ? 1 : 0;
  }
}
