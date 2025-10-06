
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    private String player1Name;
    private String player2Name;

    private final static int GAME_END_SCORE = 4;
    private final static int GAME_TIEBREAKER_ADVANTAGE = 2;

    private static String[] explicitScores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){

        if(isInValidScore()){
            return "Invalid Score!";
        }

        if (P1point == P2point) {
            return calculateDrawScore();
        }
        
        if (P1point != P2point && P1point < GAME_END_SCORE && P2point < GAME_END_SCORE)
        {
            return explicitScores[P1point] + "-" + explicitScores[P2point];
        }

        if (winnerExists()) {
            return P1point > P2point ? "Win for " + player1Name : "Win for " + player2Name;
        }

        return P1point > P2point ? "Advantage "  +player1Name : "Advantage " + player2Name;
    }

    private boolean winnerExists(){
        return (P1point >= GAME_END_SCORE || P2point >= GAME_END_SCORE) && (Math.abs(P1point-P2point) >= GAME_TIEBREAKER_ADVANTAGE);
    }
    
    private void player1Scored(){
        P1point++;
    }
    
    private void player2Scored(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name)) {
            player1Scored();
        }
        else {
            player2Scored();
        }
    }

    private String calculateDrawScore() {
        if (P1point < 3)
        {
            return explicitScores[P1point] + "-All";
        }

        return "Deuce";
    }

        private boolean isInValidScore() {
            return P1point < 0 || P2point < 0;
    }
}