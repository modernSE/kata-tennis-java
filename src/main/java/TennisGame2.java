import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{

    
    public final String PLAYER_ONE = "player1";
    public final String PLAYER_TWO = "player2";

    Map<String, Integer> pointMap = new HashMap<>(Map.of(
        PLAYER_ONE, 0, //
        PLAYER_TWO, 0 //
    ));

    Map<String, String> resMap = new HashMap<>(Map.of(
        PLAYER_ONE, "", //
        PLAYER_TWO, "" //
    ));

    public String getScore(){
        String score = "";
        if(pointMap.get(PLAYER_ONE) == pointMap.get(PLAYER_TWO)){
            score = createEqualScore();
        }
        
        if (pointMap.get(PLAYER_ONE) > 0 && pointMap.get(PLAYER_TWO)==0)
        {
           score = getScoreOneZero(PLAYER_ONE, PLAYER_TWO);
        }
        if (pointMap.get(PLAYER_TWO) > 0 && pointMap.get(PLAYER_ONE)==0)
        {
            score = getScoreOneZero(PLAYER_TWO, PLAYER_ONE);
        }
        
        if (pointMap.get(PLAYER_ONE) > pointMap.get(PLAYER_TWO) && pointMap.get(PLAYER_ONE) < 4)
        {
            score = getScoreSmallerFour(PLAYER_ONE, PLAYER_TWO);
        }
        if (pointMap.get(PLAYER_TWO) > pointMap.get(PLAYER_ONE) && pointMap.get(PLAYER_TWO) < 4)
        {
            score = getScoreSmallerFour(PLAYER_TWO, PLAYER_ONE);
        }
        
        if (pointMap.get(PLAYER_ONE) > pointMap.get(PLAYER_TWO) && pointMap.get(PLAYER_TWO) >= 3)
        {
            score = "Advantage player1";
        }
        
        if (pointMap.get(PLAYER_TWO) > pointMap.get(PLAYER_ONE) && pointMap.get(PLAYER_ONE) >= 3)
        {
            score = "Advantage player2";
        }
        
        if (pointMap.get(PLAYER_ONE) >=4 && pointMap.get(PLAYER_TWO) >=0 && (pointMap.get(PLAYER_ONE)-pointMap.get(PLAYER_TWO))>=2)
        {
            score = "Win for player1";
        }

        if (pointMap.get(PLAYER_TWO) >=4 && pointMap.get(PLAYER_ONE) >=0 && (pointMap.get(PLAYER_TWO)-pointMap.get(PLAYER_ONE))>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String createEqualScore(){
        if (pointMap.get(PLAYER_ONE)>=3)
           return "Deuce";
        String score = "";
        if (pointMap.get(PLAYER_ONE) < 3)
        {
            switch(pointMap.get(PLAYER_ONE)){
                case 0: 
                    score = "Love";
                    break;
                case 1: 
                    score = "Fifteen";
                    break;
                case 2: score = "Thirty";
            }
            score += "-All";
        }
        return score;
    }

    private String getScoreOneZero(String playerWithPoints, String playerWithoutPoints){
        switch(pointMap.get(playerWithPoints)){
            case 1:
                resMap.put(playerWithPoints, "Fifteen");
                break;
            case 2: 
                resMap.put(playerWithPoints, "Thirty");
                break;
            case 3:
                resMap.put(playerWithPoints, "Forty");
        }
    
        resMap.put(playerWithoutPoints, "Love");
        return resMap.get(PLAYER_ONE) + "-" + resMap.get(PLAYER_TWO);
    }

    private String getScoreSmallerFour(String playerWithMorePoints, String playerWithLessPoints){
        switch(pointMap.get(playerWithMorePoints)){
            case 2: 
                resMap.put(playerWithMorePoints, "Thirty");
                break; 
            case 3: 
                resMap.put(playerWithMorePoints, "Forty");
        }

        switch(pointMap.get(playerWithLessPoints)){
            case 2: 
                resMap.put(playerWithLessPoints, "Fifteen");
                break; 
            case 3: 
                resMap.put(playerWithLessPoints, "Thirty");
        }
        return resMap.get(PLAYER_ONE) + "-" + resMap.get(PLAYER_TWO);
}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        pointMap.put(PLAYER_ONE, pointMap.get(PLAYER_ONE)+1);
    }
    
    public void P2Score(){
        pointMap.put(PLAYER_TWO, pointMap.get(PLAYER_TWO)+1);
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}