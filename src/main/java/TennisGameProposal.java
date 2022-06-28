import java.util.Map;

class TennisGameProposal implements TennisGame {
    Player playerOne;
    Player playerTwo;
    Map<String, Player> players;
    ScoreConstellation score;

    TennisGameProposal(String namePlayerOne, String namePlayerTwo) {
        this.playerOne = new Player(namePlayerOne);
        this.playerTwo = new Player(namePlayerTwo);
        players = Map.of(
                namePlayerOne, playerOne,
                namePlayerTwo, playerTwo);
    }

    @Override
    public void wonPoint(String playerName) {
        players.get(playerName).wonPoint();
        score = calculateScore();
    }

    @Override
    public String getScore() {
        return score.getScore();
    }

    private ScoreConstellation calculateScore() {
        var points1 = playerOne.points.value;
        var points2 = playerTwo.points.value;

        if (points1 == points2)
            return new Deuce(playerOne.points);
        if (points1 < 4 && points2 < 4)
            return new Early(playerOne, playerTwo);

        var pointsDiff = points1 - points2;
        var playerInLead = pointsDiff > 0 ? playerOne : playerTwo;
        var leadTooBig = Math.abs(pointsDiff) >= 2;

        if (leadTooBig) {
            return new Winner(playerInLead);
        }
        return new Advantage(playerInLead);
    }

    class Player {
        String name;
        Points points = new Points();

        Player(String name) {
            this.name = name;
        }

        void wonPoint() {
            points.wonPoint();
        }
    }

    class Points {
        int value = 0;

        void wonPoint() {
            value++;
        }

        String toText() {
            return switch (value) {
                case 0 -> "Love";
                case 1 -> "Fifteen";
                case 2 -> "Thirty";
                case 3 -> "Forty";
                default -> throw new RuntimeException("Invalid points requested: " + value);
            };
        }
    }

    sealed interface ScoreConstellation permits Winner, Deuce, Early, Advantage {
        String getScore();
    }

    record Winner(Player winner) implements ScoreConstellation {
        @Override
        public String getScore() {
            return "Win for " + winner.name;
        }
    }

    record Advantage(Player player) implements ScoreConstellation {
        @Override
        public String getScore() {
            return "Advantage " + player.name;
        }
    }

    record Deuce(Points points) implements ScoreConstellation {
        @Override
        public String getScore() {
            if (points.value >= 3)
                return "Deuce";
            return points.toText() + "-All";
        }
    }

    record Early(Player playerOne, Player playerTwo) implements ScoreConstellation {
        @Override
        public String getScore() {
            return playerOne.points.toText() + "-" + playerTwo.points.toText();
        }

    }

}