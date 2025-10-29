public class ScoreTranslator {

    private String player1Name;
    private String player2Name;

    public ScoreTranslator(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

    }

    public String translateGameOver(int P1point, int P2point) {
        return "Win for " + getLeadingPlayerName(P1point, P2point);
    }

    public String translateTied(int points) {
        if (points <= 2) {
            return translatePoint(points) + "-All";
        } else {
            return "Deuce";
        }
    }

    public String translateAdvantage(int P1point, int P2point) {
        return "Advantage " + getLeadingPlayerName(P1point, P2point);
    }

    public String translateRegular(int P1point, int P2point) {
        return translatePoint(P1point) + "-" + translatePoint(P2point);
    }

    private String translatePoint(int point) {
        return switch (point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

    private String getLeadingPlayerName(int P1point, int P2point) {
        return P1point > P2point ? player1Name : player2Name;
    }
}
