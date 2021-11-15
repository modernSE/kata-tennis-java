import java.util.Optional;

public class TennisGame3 implements TennisGame {
    private static final String[] SCORE_WORDS = new String[] {"Love", "Fifteen", "Thirty", "Forty"}; 

    private int playerTwoScore;
    private int playerOneScore;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        return tryFormatDraw(playerOneScore, playerTwoScore)
            .or(() -> tryFormatAdvantage(playerOneName, playerOneScore, playerTwoName, playerTwoScore))
            .or(() -> tryFormatWin(playerOneName, playerOneScore, playerTwoName, playerTwoScore))
            .orElseGet(() -> formatTwoComponentScore(playerOneScore, playerTwoScore));
    }

    private static Optional<String> tryFormatDraw(int playerOneScore, int playerTwoScore) {
        if (playerOneScore != playerTwoScore) {
            return Optional.empty();
        }

        if (playerOneScore < 3) {
            return Optional.of(String.format("%s-All", getScoreWord(playerOneScore)));
        } else {
            return Optional.of("Deuce");
        }
    }

    private static Optional<String> tryFormatAdvantage(String playerOneName, int playerOneScore, String playerTwoName, int playerTwoScore) {
        return tryFormatAdvantageForLeftPlayer(playerOneName, playerOneScore, playerTwoScore)
            .or(() -> tryFormatAdvantageForLeftPlayer(playerTwoName, playerTwoScore, playerOneScore));
    }

    private static Optional<String> tryFormatAdvantageForLeftPlayer(String leftName, int leftScore, int rightScore) {
        if (leftScore < 4 || leftScore - rightScore != 1) {
            return Optional.empty();
        }

        return Optional.of(String.format("Advantage %s", leftName));
    }

    private static Optional<String> tryFormatWin(String playerOneName, int playerOneScore, String playerTwoName, int playerTwoScore) {
        return tryFormatWinForLeftPlayer(playerOneName, playerOneScore, playerTwoScore)
            .or(() -> tryFormatWinForLeftPlayer(playerTwoName, playerTwoScore, playerOneScore));
    }

    private static Optional<String> tryFormatWinForLeftPlayer(String leftName, int leftScore, int rightScore) {
        if (leftScore < 4 || leftScore - rightScore < 2) {
            return Optional.empty();
        }

        return Optional.of(String.format("Win for %s", leftName));
    }

    private static String formatTwoComponentScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s-%s", getScoreWord(playerOneScore), getScoreWord(playerTwoScore));
    }

    private static String getScoreWord(int score) {
        return SCORE_WORDS[score];
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals(playerOneName)) {
            this.playerOneScore += 1;
        } else {
            this.playerTwoScore += 1;
        }
    }

}
