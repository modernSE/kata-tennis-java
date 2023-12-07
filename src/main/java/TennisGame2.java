
public class TennisGame2 implements TennisGame
{
    public int scorePlayer1 = 0;
    public int scorePlayer2 = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public String getScore(){
        if (hasWon(scorePlayer1, scorePlayer2)) return "Win for player1";
        if (hasWon(scorePlayer2, scorePlayer1)) return "Win for player2";

        if (scorePlayer1 == scorePlayer2 && scorePlayer1>=3) return "Deuce";

        if (hasAdvantage(scorePlayer1, scorePlayer2)) return "Advantage player1";
        if (hasAdvantage(scorePlayer2, scorePlayer1)) return "Advantage player2";

        if (scorePlayer1 == scorePlayer2 && scorePlayer1 < 4)  return getResultForPoints(scorePlayer1) + "-All";

        return getResultForPoints(scorePlayer1) + "-" + getResultForPoints(scorePlayer2);       
    }

    @Override
    public void wonPoint(String player) {
        if (player == "player1") {
            scorePlayer1++;
        } else  {
            scorePlayer2++;
        }
    }

    private boolean hasAdvantage(int pointsA, int pointsB) {
        return pointsA > pointsB && pointsB >= 3;
    }

    private boolean hasWon(int pointsA, int pointsB) {
        return pointsA >= 4 && pointsB >= 0 && (pointsA - pointsB)>=2;
    }

    private String getResultForPoints(int point) {
        return switch(point) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    } 
}