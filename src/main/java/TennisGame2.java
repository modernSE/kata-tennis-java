
public class TennisGame2 implements TennisGame {
    //TODO
    //public static final String ADVANTAGE_TAG = "Advantage";


    public int P1point = 0;
    public int P2point = 0;

    public TennisGame2(String player1Name, String player2Name) {

    }

    public String getScore() {
        String score = convertScore(P1point) + "-" + convertScore(P2point);

        if (isOvertime()) {
            score = "Advantage " + getLeadingPlayer();
        }

        if (isTied()) {
            if (getMaxScore() < 3) {
                score = convertScore(P1point) + "-All";
            } else {
                score = "Deuce";
            }
        }

        if (isWin()) {
            score = "Win for " + getLeadingPlayer();
        }
        return score;
    }

    public boolean isTied() {
        return P1point == P2point;
    }

    public boolean isWin() {
        return getMaxScore() >= 4 && Math.abs(P2point - P1point) >= 2;
    }

    public String getLeadingPlayer() {
        if (P1point > P2point) {
            return "player1";
        } else {
            return "player2";
        }
    }

    public boolean isOvertime() {
        return getMaxScore() > 3;
    }

    public int getMaxScore() {
        return Math.max(P2point, P1point);
    }

    public String convertScore(int points) {
        if (points == 0)
            return "Love";
        if (points == 1)
            return "Fifteen";
        if (points == 2)
            return "Thirty";
        if (points == 3)
            return "Forty";

        return "?";
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}