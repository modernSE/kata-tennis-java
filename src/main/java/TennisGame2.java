
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /*
     * - Spiel vorbei: mind. 4 punkte, mind. 2 Unterschied
     * - 4 Punkte erreicht, aber nicht vorbei -> Advantage / Douce
     * - noch nicht 4 punkte erreicht: Unentschieden / nicht unentschieden
     * 
     * if unentschieden
     * - douce
     * - Love / Fifteen / Thirty All
     * 
     * sonst
     * - vorbei
     * - advantage
     * - normaler score
     */

    public String getScore() {
        if (scoreIsGameOver(P1point, P2point)) {
            return "Win for " + getLeadingPlayerName(P1point, P2point);
        } else if (scoreIsTied(P1point, P2point)) {
            if (P1point <= 2) {
                return translatePoint(P1point) + "-All";
            }
            else {
                return "Deuce";
            }
        } else if (scoreIsAdvantage(P1point, P2point)) {
            return "Advantage " + getLeadingPlayerName(P1point, P2point);
        } else {
            return translatePoint(P1point) + "-" + translatePoint(P2point);
        }
    }

    private boolean scoreIsGameOver(int P1point, int P2point) {
        return Math.max(P1point, P2point) >= 4 && Math.abs(P1point - P2point) >= 2;
    }

    private boolean scoreIsTied(int P1point, int P2point) {
        return P1point == P2point;
    }

    private boolean scoreIsAdvantage(int P1Point, int P2point) {
        return Math.max(P1Point, P2point) >= 4 && Math.abs(P1Point - P2point) == 1;
    }

    private String translatePoint(int point) {
        return switch(point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

    private String getLeadingPlayerName(int P1point, int P2point) {
        return P1point > P2point ? "player1" : "player2";
    }

    public String getScoreOld() {
        String score = "";
        if (P1point == P2point && P1point < 4) {
            if (P1point == 0)
                score = "Love";
            if (P1point == 1)
                score = "Fifteen";
            if (P1point == 2)
                score = "Thirty";
            score += "-All";
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        if (P1point > 0 && P2point == 0) {
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point == 0) {
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P1point < 4) {
            if (P1point == 2)
                P1res = "Thirty";
            if (P1point == 3)
                P1res = "Forty";
            if (P2point == 1)
                P2res = "Fifteen";
            if (P2point == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point && P2point < 4) {
            if (P2point == 2)
                P2res = "Thirty";
            if (P2point == 3)
                P2res = "Forty";
            if (P1point == 1)
                P1res = "Fifteen";
            if (P1point == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
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