import java.util.Optional;

public class TennisGame2 implements TennisGame
{
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;
    
    private String playerOneScoreValue = "";
    private String playerTwoScoreValue = "";

    public TennisGame2() {
    }

    public String getResult(){
        String result = baseScore().orElse("");
        Optional<String> to0Score = to0Score();
        result = to0Score.isPresent() ? to0Score.get() : result;
        Optional<String> smaller4Score = getSmaller4Score();
        result = smaller4Score.isPresent() ? smaller4Score.get() : result;
        Optional<String> scoreComplex = getScoreForComplexPoints();
        return scoreComplex.isPresent() ? scoreComplex.get() : result;
    }

    private Optional<String> baseScore() {
        String result = null;
        if (playerOnePoints == playerTwoPoints && playerOnePoints < 4)
        {
            if (playerOnePoints < 3) {
                result = getScoreForSimplePoints(playerOnePoints);
            }
            result += "-All";
        }
        if (playerOnePoints==playerTwoPoints && playerOnePoints>=3) {
            result = "Deuce";
        }
        return Optional.ofNullable(result);
    }

    private Optional<String> to0Score() {
        String result = null;
        if (playerOnePoints > 0 && playerTwoPoints==0)
        {
            if (playerOnePoints <= 3) {
                playerOneScoreValue = getScoreForSimplePoints(playerOnePoints);
            }
            
            playerTwoScoreValue = "Love";
            result = getResultFromScoreValues();
        }
        if (playerTwoPoints > 0 && playerOnePoints==0)
        {
            if (playerTwoPoints <= 3) {
                playerTwoScoreValue = getScoreForSimplePoints(playerTwoPoints);
            }
            
            playerOneScoreValue = "Love";
            result = getResultFromScoreValues();
        }
        return Optional.ofNullable(result);
    }

    private Optional<String> getSmaller4Score() {
        String result = null;
        if (playerOnePoints>playerTwoPoints && playerOnePoints < 4)
        {
            if (playerOnePoints == 2 || playerOnePoints == 3) {
                playerOneScoreValue = getScoreForSimplePoints(playerOnePoints);
            }

            if (playerTwoPoints==1 || playerTwoPoints==2) {
                playerTwoScoreValue = getScoreForSimplePoints(playerTwoPoints);
            }
            result = getResultFromScoreValues();
        }

        if (playerTwoPoints>playerOnePoints && playerTwoPoints < 4)
        {
            if (playerOnePoints==1 || playerOnePoints==2) {
                playerOneScoreValue = getScoreForSimplePoints(playerOnePoints);
            }

            if (playerTwoPoints == 2 || playerTwoPoints == 3) {
                playerTwoScoreValue = getScoreForSimplePoints(playerTwoPoints);
            }
            result = getResultFromScoreValues();
        }
        return Optional.ofNullable(result);
    } 

    private String getResultFromScoreValues() {
        return playerOneScoreValue + "-" + playerTwoScoreValue;
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