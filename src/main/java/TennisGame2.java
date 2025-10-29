import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    private static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    private static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    private static final String DEUCE = "Deuce";
    private static final String ALL = "-All";
    public int player1point = 0;
    public int player2point = 0;
    
    public String player1res = "";
    public String player2res = "";
    private String player1Name;
    private String player2Name;

    

    static final class TennisScorboardMap {
        private static TennisScorboardMap instance;
        private Map<Integer, String> tennisScorboardMap = new HashMap<Integer, String>();
        private TennisScorboardMap() {
            tennisScorboardMap.put(0, "Love");
            tennisScorboardMap.put(1, "Fifteen");
            tennisScorboardMap.put(2, "Thirty");
            tennisScorboardMap.put(3, "Forty");
        }

        static String getWord(int number) {
            if (instance == null) {
                instance = new TennisScorboardMap();
            }
            return instance.tennisScorboardMap.get(number);
        }
    }

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (isDraw() && player1point < 3)
        {
            if (isUnderLimit(player1point, 3)) {
                score = TennisScorboardMap.getWord(player1point);
            }
            score += ALL;
        }
        else if (isDraw() && player1point>=3)
            score = DEUCE;
        else if (isUnderLimit(player1point, 4)  && isUnderLimit(player2point, 4))
        {   
            player1res = TennisScorboardMap.getWord(player1point);
            player2res = TennisScorboardMap.getWord(player2point);

            score = player1res + "-" + player2res;
        }
        
        if (player1point > player2point && player2point >= 3)
        {
            score = ADVANTAGE_PLAYER1;
        }
        
        if (player2point > player1point && player1point >= 3)
        {
            score = ADVANTAGE_PLAYER2;
        }
        
        if (player1point>=4 && player2point>=0 && winConditionPlayer1())
        {
            score = "Win for player1";
        }
        if (player2point>=4 && player1point>=0 && winConditionPlayer2())
        {
            score = "Win for player2";
        }
        return score;
    }

    private boolean winConditionPlayer1() {
        return (player1point-player2point)>=2;
    }

    private boolean winConditionPlayer2() {
        return (player2point-player1point)>=2;
    }

    private boolean isUnderLimit(int points, int limit) {
        return points >= 0 && points < limit;
    }

    private boolean isDraw() {
        return player1point == player2point;
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
        player1point++;
    }
    
    public void P2Score(){
        player2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}