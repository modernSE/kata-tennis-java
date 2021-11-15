
public class TennisGame2 implements TennisGame
{
    public int p1Score = 0;
    public int p2Score = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private String equalAndLessThanFour() {
        String score = "";

        if (p1Score==0)
            score = "Love";
        if (p1Score==1)
            score = "Fifteen";
        if (p1Score==2)
            score = "Thirty";

        score += "-All";

        return score;
    }

    private String p2Love() {
        if (p1Score==1)
            P1res = "Fifteen";
        if (p1Score==2)
            P1res = "Thirty";
        if (p1Score==3)
            P1res = "Forty";
        
        P2res = "Love";

        return P1res + "-" + P2res;
    }

    private String p1Love() {
        if (p2Score==1)
            P2res = "Fifteen";
        if (p2Score==2)
            P2res = "Thirty";
        if (p2Score==3)
            P2res = "Forty";
        
        P1res = "Love";
        return P1res + "-" + P2res;
    }

    private String p1IsLeading() {
        if (p1Score==2)
            P1res="Thirty";
        if (p1Score==3)
            P1res="Forty";
        if (p2Score==1)
            P2res="Fifteen";
        if (p2Score==2)
            P2res="Thirty";

        return P1res + "-" + P2res;
    }

    private String p2IsLeading() {
        if (p2Score==2)
            P2res="Thirty";
        if (p2Score==3)
            P2res="Forty";
        if (p1Score==1)
            P1res="Fifteen";
        if (p1Score==2)
            P1res="Thirty";

        return P1res + "-" + P2res;
    }

    public String getScore(){
        String score = "";

        if (p1Score == p2Score && p1Score < 4) {
            score += equalAndLessThanFour();
        }

        if (p1Score==p2Score && p1Score>=3)
            score = "Deuce";
        
        if (p1Score > 0 && p2Score==0) {
            score = p2Love();
        }

        if (p2Score > 0 && p1Score==0) {
            score = p1Love();
        }
        
        if (p1Score>p2Score && p1Score < 4) {
            score = p1IsLeading();
        }
        if (p2Score>p1Score && p2Score < 4) {
            score = p2IsLeading();
        }
        
        if (p1Score > p2Score && p2Score >= 3)
        {
            score = "Advantage player1";
        }
        
        if (p2Score > p1Score && p1Score >= 3)
        {
            score = "Advantage player2";
        }
        
        if (p1Score>=4 && p2Score>=0 && (p1Score-p2Score)>=2)
        {
            score = "Win for player1";
        }
        if (p2Score>=4 && p1Score>=0 && (p2Score-p1Score)>=2)
        {
            score = "Win for player2";
        }
        return score;
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
        p1Score++;
    }
    
    public void P2Score(){
        p2Score++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}