
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

    public String getScore() {
        String score = "";

        if (P1point == P2point) {
            if (P1point <= 4) {
                score = switch (P1point) {
                    case 0 -> "Love-All";
                    case 1 -> "Fifteen-All";
                    case 2 -> "Thirty-All";
                    default -> "Deuce";
                };
            }
        } else if (P1point < 4 && P2point < 4) {
            P1res = getScoreForPlayer(P1point);
            P2res = getScoreForPlayer(P2point);

            score = P1res + "-" + P2res;
        } else if (P1point >= 4 || P2point >= 4) {
            int pointdiff = P1point - P2point;
            if (pointdiff <= -2)
                score = "Win for player2";
            else if (pointdiff == -1)
                score = "Advantage player2";
            else if (pointdiff == 1)
                score = "Advantage player1";
            else
                score = "Win for player1";

        }

        return score;
    }

    private String getScoreForPlayer(int point) {
        return switch (point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
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