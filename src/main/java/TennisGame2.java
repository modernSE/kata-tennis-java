
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private ScoreTranslator scoreTranslator;

    public TennisGame2(String player1Name, String player2Name) {
        this.scoreTranslator = new ScoreTranslator(player1Name, player2Name);
    }

    public String getScore() {
        if (scoreIsGameOver(P1point, P2point)) {
            return scoreTranslator.translateGameOver(P1point, P2point);
        } else if (scoreIsTied(P1point, P2point)) {
            return scoreTranslator.translateTied(P1point);
        } else if (scoreIsAdvantage(P1point, P2point)) {
            return scoreTranslator.translateAdvantage(P1point, P2point);
        } else {
            return scoreTranslator.translateRegular(P1point, P2point);
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