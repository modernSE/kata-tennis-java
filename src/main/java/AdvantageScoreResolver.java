
public class AdvantageScoreResolver implements ScoreResolver {

    @Override
    public String resolve(PlayerState player1, PlayerState player2) {
        PlayerState winner = player1.score() > player2.score() ? player1 : player2;
        return "Advantage " + winner.name();
    }

    @Override
    public boolean isApplicable(PlayerState player1, PlayerState player2) {
        return player1.score() >= 3 && player2.score() >= 3 && Math.abs(player1.score() - player2.score()) == 1;
    }

}
