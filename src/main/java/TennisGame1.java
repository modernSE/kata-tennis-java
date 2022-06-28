
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (scoresEqual()) {
            return resumeDraw();
        }
        if (playerWins())
        {
            return resumeWin();
        }
        return resumeScore(score, tempScore);
    }

    private String resumeWin() {
        int scoreDifference = m_score1-m_score2;
        if (scoreDifference==1) return "Advantage player1";
        if (scoreDifference ==-1) return "Advantage player2";
        if (scoreDifference>=2) return "Win for player1";
        return "Win for player2";
    }

    private String resumeScore(String score, int tempScore) {
        for (int round=1; round<3; round++)
        {
            if (round==1) tempScore = m_score1;
            else { score+="-"; tempScore = m_score2;}
            score = concatHistoricNameToScore(score, tempScore);
        }
        return score;
    }

    private String concatHistoricNameToScore(String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        return score;
    }

    private boolean playerWins() {
        return m_score1>=4 || m_score2>=4;
    }

    private boolean scoresEqual() {
        return m_score1==m_score2;
    }

    private String resumeDraw() {
        String score;
        switch (m_score1)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;
            
        }
        return score;
    }
}
