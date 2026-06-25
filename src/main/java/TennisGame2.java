
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private Player player1;
    private Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getScore() {
        if (P1point < 0 || P2point < 0) {
            throw new IllegalStateException("Score can't be negative.");
        }

        Player winner = getWinner(P1point, P2point);

        if (winner != null) {
            return "Win for " + winner.name;
        }

        Player advantage = getAdvantage(P1point, P2point);

        if (advantage != null) {
            return "Advantage " + advantage.name;
        }

        String score = "";

        if (P1point == P2point) {

            if (P1point < 4) {
                score = getPointDescription(P1point);
                score += "-All";
            }
            if (P1point >= 3)
                score = "Deuce";
        } else {
            P1res = getPointDescription(P1point);
            P2res = getPointDescription(P2point);

            score = P1res + "-" + P2res;

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

    private String getPointDescription(int points) {
        /*
         * if (points >= 4) {
         * throw new IllegalArgumentException("Can't describe points bigger than 4");
         * }
         */

        return switch (points) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> null;
        };
    }

    private Player getWinner(int point1, int point2) {
        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            return this.player1;
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            return this.player2;
        }

        return null;
    }



    private Player getAdvantage(int point1, int point2) {
        if (P1point > P2point && P2point >= 3) {
            return this.player1;
        }

        if (P2point > P1point && P1point >= 3) {
            return this.player2;
        }

        return null;
    }
}