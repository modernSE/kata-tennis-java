
public class TennisGame2 implements TennisGame {

    private int p1point = 0;
    private int p2point = 0;

    public TennisGame2(String player1Name, String player2Name) {

    }

    public void wonPoint(String player) {
        if (player == "player1")
            p1Score();
        else
            p2Score();
    }

    public String getScore() {
        String p1res = "";
        String p2res = "";
        String score = "";

        if (p1point == p2point && p1point < 3) {
            p1res = pointsLessThanFour(p1point);
            p2res = "All";
            return p1res + "-" + p2res;
        }
        if (p1point == p2point && p1point >= 3)
            return "Deuce";

        if (p1point > 0 && p2point == 0 && p1point < 4) {
            p1res = pointsLessThanFour(p1point);
            p2res = "Love";
            return p1res + "-" + p2res;
        }
        if (p2point > 0 && p1point == 0 && p2point < 4) {
            p2res = pointsLessThanFour(p2point);
            p1res = "Love";
            return p1res + "-" + p2res;
        }

        if (p1point > p2point && p1point < 4) {
            p1res = pointsLessThanFour(p1point);
            p2res = pointsLessThanFour(p2point);
            return p1res + "-" + p2res;
        }
        if (p2point > p1point && p2point < 4) {
            if (p2point == 2)
                p2res = "Thirty";
            if (p2point == 3)
                p2res = "Forty";
            if (p1point == 1)
                p1res = "Fifteen";
            if (p1point == 2)
                p1res = "Thirty";
            return p1res + "-" + p2res;
        }

        if (p1point > p2point && (p1point - p2point) < 2) {
            return "Advantage player1";
        }

        if (p2point > p1point && (p2point - p1point) < 2) {
            return "Advantage player2";
        }

        if (p1point >= 4 && p2point >= 0 && (p1point - p2point) >= 2) {
            return "Win for player1";
        }
        if (p2point >= 4 && p1point >= 0 && (p2point - p1point) >= 2) {
            return "Win for player2";
        }
        return score;
    }

    private void p1Score() {
        p1point++;
    }

    private void p2Score() {
        p2point++;
    }

    private String pointsLessThanFour(int points) {
        if (points == 0)
            return "Love";
        if (points == 1)
            return "Fifteen";
        if (points == 2)
            return "Thirty";
        if (points == 3)
            return "Forty";

        return "not implemented";
    }

}