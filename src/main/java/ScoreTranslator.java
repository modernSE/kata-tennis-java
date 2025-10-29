public class ScoreTranslator {

    public static String translateGameOver(int P1point, int P2point) {
        return "Win for " + getLeadingPlayerName(P1point, P2point);
    }

    public static String translateTied(int points) {
        if (points <= 2) {
            return translatePoint(points) + "-All";
        } else {
            return "Deuce";
        }
    }

    public static String translateAdvantage(int P1point, int P2point) {
        return "Advantage " + getLeadingPlayerName(P1point, P2point);
    }

    public static String translateRegular(int P1point, int P2point) {
        return translatePoint(P1point) + "-" + translatePoint(P2point);
    }

    private static String translatePoint(int point) {
        return switch (point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

    private static String getLeadingPlayerName(int P1point, int P2point) {
        return P1point > P2point ? "player1" : "player2";
    }
}
