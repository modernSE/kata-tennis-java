import java.util.Map;

public class IntermediateScoreResolver implements ScoreResolver {

    private final static Map<Integer, String> scoreToName = Map.of( //
            0, "Love", //
            1, "Fifteen", //
            2, "Thirty", //
            3, "Fourty //");

    @Override
    public String resolve(PlayerState player1, PlayerState player2) {
        return scoreToName.get(player1.score()) + "-" + scoreToName.get(player2.score());
    }

    @Override
    public boolean isApplicable(PlayerState player1, PlayerState player2) {
        return player1.score() > 3 && player2.score() >= 3 && Math.abs(player1.score() - player2.score()) == 1;
    }

}
