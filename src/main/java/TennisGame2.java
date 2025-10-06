
public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    
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

        if (player1Point == player2Point) {
            return calculateDrawScore();
        }
        
        if (player1Point != player2Point && player1Point < GAME_END_SCORE && player2Point < GAME_END_SCORE)
        {
            return explicitScores[player1Point] + "-" + explicitScores[player2Point];
        }

        if (winnerExists()) {
            return player1Point > player2Point ? "Win for " + player1Name : "Win for " + player2Name;
        }

        return player1Point > player2Point ? "Advantage "  +player1Name : "Advantage " + player2Name;
    }

    private boolean winnerExists(){
        return (player1Point >= GAME_END_SCORE || player2Point >= GAME_END_SCORE) && (Math.abs(player1Point-player2Point) >= GAME_TIEBREAKER_ADVANTAGE);
    }
    
    private void player1Scored(){
        player1Point++;
    }
    
    private void player2Scored(){
        player2Point++;
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
        if (player1Point < 3)
        {
            return explicitScores[player1Point] + "-All";
        }

        return "Deuce";
    }

        private boolean isInValidScore() {
            return player1Point < 0 || player2Point < 0;
    }
}