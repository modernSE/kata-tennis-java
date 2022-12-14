public class TennisGame5 implements TennisGame {
    
    Player player1;
    Player player2;

    public TennisGame5(String namePlayer1, String namePlayer2) {
        player1 = new Player(namePlayer1);
        player2 = new Player(namePlayer2);
    }

    public String getScore() {
        return null;
    }

    public void wonPoint(String player) {
        if (player1.name == player) {
            player1.currentScore += 1;
        }
        else {
            player2.currentScore += 1;
        }
    }
    


    public class Player {

        String name;
        int currentScore;

        public Player(String name) {
            this.name = name;
        }
    }


}


