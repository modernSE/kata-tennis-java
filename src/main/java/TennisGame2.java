
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
    
        if (P1point == P2point && P1point < 3) return getPointsAsString(P1point) + "-All";
        if (P1point == P2point)                return "Deuce";
        if (P1point < 4 && P2point < 4)        return getPointsAsString(P1point) + "-" + getPointsAsString(P2point);
        if ((P1point-P2point)>1)               return "Win for player1";
        if ((P2point-P1point)>1)               return "Win for player2";
        if (P1point > P2point)                 return "Advantage player1";        
        if (P2point > P1point)                 return "Advantage player2";
        return "fuck you";
    }

    private String getPointsAsString(int points) {

        return switch (points) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "0";
        };
    }
    
    public void wonPoint(String player) {
        if (player == player1Name)
            P1point++;
        else 
            P2point++;
    }
}