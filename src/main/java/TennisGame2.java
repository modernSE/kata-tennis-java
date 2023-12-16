import java.util.*;
public class TennisGame2 implements TennisGame
{
    private class Player{
        public int points = 0;
        public String result = "";
        public String name;

        public Player(String name){
            this.name = name;
        }
    }

    public Player player1;
    public Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore(){
        String score = "";

        Map<Integer, String> pointMap = new HashMap<>();
        pointMap.put(0, "Love");
        pointMap.put(1, "Fifteen");
        pointMap.put(2, "Thirty");
        pointMap.put(3, "Forty");

        if (player1.points == player2.points && player1.points < 4)
        {
            score = pointMap.get(player1.points) + "-All";
        }

        if (player1.points == player2.points && player1.points >= 3)
            score = "Deuce";
        
        if (player1.points > 0 && player2.points == 0)
        {
            player1.result = pointMap.get(player1.points);
            player2.result = "Love";
            score = player1.result + "-" + player2.result;
        }
        if (player2.points > 0 && player1.points==0)
        {
            player2.result = pointMap.get(player2.points);            
            player1.result = "Love";
            score = player1.result + "-" + player2.result;
        }
        
        if (player1.points>player2.points && player1.points < 4)
        {
            player1.result = pointMap.get(player1.points);   
            player2.result = pointMap.get(player2.points);
            score = player1.result + "-" + player2.result;
        }
        if (player2.points>player1.points && player2.points < 4)
        {
            player1.result = pointMap.get(player1.points);   
            player2.result = pointMap.get(player2.points);
            score = player1.result + "-" + player2.result;
        }

        score = GetFinalScore(score);

        return score;
    }

    public String GetFinalScore(String score){

        score = GetPlayerAdvantage(score);
        score = GetPlayerWin(score);

        return score;
    }

    public String GetPlayerAdvantage(String score){
        
        if (player1.points > player2.points && player2.points >= 3)
        {
            score = "Advantage " + player1.name;
        }
        
        if (player2.points > player1.points && player1.points >= 3)
        {
            score = "Advantage " + player2.name;
        }       

        return score;
    }

    public String GetPlayerWin(String score){

        if (player1.points>=4 && player2.points>=0 && (player1.points-player2.points)>=2)
        {
            score = "Win for " + player1.name;
        }
        
        if (player2.points>=4 && player1.points>=0 && (player2.points-player1.points)>=2)
        {
            score = "Win for " + player2.name;
        }

        return score;
    }
    
    public void SetP1Score(int number){
        player1.points = player1.points + number;
    }
    
    public void SetP2Score(int number){
        player2.points = player2.points + number;
    }
    
    public void P1Score(){
        player1.points++;
    }
    
    public void P2Score(){
        player2.points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}