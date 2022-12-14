
public class TennisGame2 implements TennisGame {
    public int pointsPlayer1 = 0;
    public int pointsPlayer2 = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        score = convertPointsToString(pointsPlayer1) + "-" + convertPointsToString(pointsPlayer2);

        if (pointsPlayer1 == pointsPlayer2 && pointsPlayer1 < 4) {
            score = convertPointsToString(pointsPlayer1);
            score += "-All";
        }

        if (pointsPlayer1 >= 3 && pointsPlayer2 >= 3) {
            if (pointsPlayer1 == pointsPlayer2) {
                return "Deuce";
            }
            return "Advantage " + (pointsPlayer1 > pointsPlayer2 ? player1Name : player2Name);
        }

        if (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) {
            if (getDistance(pointsPlayer2, pointsPlayer1) >= 2) {
                score = "Win for " + (doesALeadWith2Points(pointsPlayer1, pointsPlayer2) ? player1Name : player2Name);
            }
        }
        return score;
    }

    private int getDistance(int pointsA, int pointsB) {
        return Math.abs(pointsA - pointsB);
    }

    private boolean doesALeadWith2Points(int pointsA, int pointsB) {
        return (pointsA - pointsB) >= 2;
    }

    private boolean isATheWinner(int pointsA, int pointsB) {
        return pointsA > pointsB;
    }

    private String convertPointsToString(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
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
        pointsPlayer1++;
    }

    public void P2Score() {
        pointsPlayer2++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}