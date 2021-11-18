
public class TennisGame1 implements TennisGame {

    private static final String UNKOWN = "UNKOWN";
    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private static final String WIN_FOR = "Win for ";
    private static final String ADVANTAGE = "Advantage ";
    private static final String DEUCE = "Deuce";
    private static final String FIFTEEN = "Fifteen";
    private static final String ALL = "All";
    private static final String LOVE = "Love";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (playersHaveEqualPoints(m_score1, m_score2)) {
            return getScoreForEqualPoints(m_score1);
        } else if (eitherPlayHasAtLeastFourPoints(m_score1, m_score2)) {
            return getScoreForWinOrAdvantage(m_score1, m_score2);
        } else {
            return getScore(m_score1) + "-" + getScore(m_score2);
        }
    }

    private boolean playersHaveEqualPoints(int player1Points, int player2Points) {
        return player1Points == player2Points;
    }

    private boolean eitherPlayHasAtLeastFourPoints(int player1Points, int player2Points) {
        return player1Points >= 4 || player2Points >= 4;
    }

    private String getScoreForEqualPoints(int points) {
        switch (m_score1) {
        case 0:
            return LOVE + "-" + ALL;
        case 1:
            return FIFTEEN + "-" + ALL;
        case 2:
            return THIRTY + "-" + ALL;
        default:
            return DEUCE;

        }
    }

    private String getScoreForWinOrAdvantage(int player1Points, int player2Points) {
        int minusResult = player1Points - player2Points;

        if (minusResult == 1) {
            return ADVANTAGE + PLAYER1;
        } else if (minusResult == -1) {
            return ADVANTAGE + PLAYER2;
        } else if (minusResult >= 2) {
            return WIN_FOR + PLAYER1;
        } else {
            return WIN_FOR + PLAYER2;
        }
    }

    private String getScore(int points) {
        switch (points) {
        case 0:
            return LOVE;
        case 1:
            return FIFTEEN;
        case 2:
            return THIRTY;
        case 3:
            return FORTY;
        }
        return UNKOWN;
    }
}
