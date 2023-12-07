import java.util.Optional;

public class TennisGame2 implements TennisGame
{
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;
    
    private String playerOneResult = "";
    private String playerTwoResult = "";

    //TODO: remove v
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (playerOnePoints == playerTwoPoints && playerOnePoints < 4)
        {
            if (playerOnePoints < 3) {
                score = getScoreForSimplePoints(playerOnePoints);
            }
            score += "-All";
        }
        if (playerOnePoints==playerTwoPoints && playerOnePoints>=3) {
            score = "Deuce";
        }
        
        if (playerOnePoints > 0 && playerTwoPoints==0)
        {
            if (playerOnePoints <= 3) {
                playerOneResult = getScoreForSimplePoints(playerOnePoints);
            }
            
            playerTwoResult = "Love";
            score = getScoreFromResults();
        }
        if (playerTwoPoints > 0 && playerOnePoints==0)
        {
            if (playerTwoPoints <= 3) {
                playerTwoResult = getScoreForSimplePoints(playerTwoPoints);
            }
            
            playerOneResult = "Love";
            score = getScoreFromResults();
        }
        
        if (playerOnePoints>playerTwoPoints && playerOnePoints < 4)
        {
            if (playerOnePoints == 2 || playerOnePoints == 3) {
                playerOneResult = getScoreForSimplePoints(playerOnePoints);
            }

            if (playerTwoPoints==1 || playerTwoPoints==2) {
                playerTwoResult = getScoreForSimplePoints(playerTwoPoints);
            }
            score = getScoreFromResults();
        }

        if (playerTwoPoints>playerOnePoints && playerTwoPoints < 4)
        {
            if (playerTwoPoints == 2 || playerTwoPoints == 3) {
                playerTwoResult = getScoreForSimplePoints(playerTwoPoints);
            }

            if (playerOnePoints==1 || playerOnePoints==2) {
                playerOneResult = getScoreForSimplePoints(playerOnePoints);
            }
            score = getScoreFromResults();
        }
        
        Optional<String> scoreComplex = getScoreForComplexPoints();
        return scoreComplex.isPresent() ? scoreComplex.get() : score;
    }

    private String getScoreFromResults() {
        return playerOneResult + "-" + playerTwoResult;
    }

    private String getScoreForSimplePoints(final int points) {
        return switch(points) { 
            case 0: yield "Love";
            case 1: yield "Fifteen";
            case 2: yield "Thirty";
            case 3: yield "Forty";
            default: throw new IllegalArgumentException("must be 0-3");
        };
    }

    private Optional<String> getScoreForComplexPoints() {
        String score = null;
        if (playerOnePoints > playerTwoPoints && playerTwoPoints >= 3)
        {
            score = "Advantage player1";
        }
        
        if (playerTwoPoints > playerOnePoints && playerOnePoints >= 3)
        {
            score = "Advantage player2";
        }
        
        if (playerOnePoints>=4 && playerTwoPoints>=0 && (playerOnePoints-playerTwoPoints)>=2)
        {
            score = "Win for player1";
        }
        if (playerTwoPoints>=4 && playerOnePoints>=0 && (playerTwoPoints-playerOnePoints)>=2)
        {
            score = "Win for player2";
        }
        return Optional.ofNullable(score);
    }
    
    private void setPlayerOneScore(int number){
        for (int i = 0; i < number; i++)
        {
            incrementPlayerOneScore();
        }
    }
    
    private void setPlayerTwoScore(int number){
        for (int i = 0; i < number; i++)
        {
            incrementPlayerTwoScore();
        }
    }
    
    private void incrementPlayerOneScore(){
        playerOnePoints++;
    }
    
    private void incrementPlayerTwoScore(){
        playerTwoPoints++;
    }

    private void increment() {
        //TODO
    }

    public void wonPoint(String player) {
        if (player == "player1")
            incrementPlayerOneScore();
        else
            incrementPlayerTwoScore();
    }
}