package piglatin;

import java.util.StringTokenizer;

class Score {
    private int sum = 0;

    Score() {
    }

    /**
     * Scores a string.
     * Returns the single score but also sums up internally.
     *
     * @see getScore
     */
    public int score(final String solution, final String answer) {
        StringTokenizer t1 = new StringTokenizer(solution);
        StringTokenizer t2 = new StringTokenizer(answer);
        int v = 0;
        while(t1.hasMoreTokens() && t2.hasMoreTokens()) {
            v += t1.nextToken().equals(t2.nextToken()) ? 1 : 0;
        }
        sum += v;
        return v;
    }

    /**
     * Get accumulated score
     */
    public int getScore() {
        return sum;
    }
}
