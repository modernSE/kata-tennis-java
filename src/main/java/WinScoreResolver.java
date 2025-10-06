
public class WinScoreResolver implements ScoreResolver {

    @Override
    public String resolve(PlayerState player1, PlayerState player2) {
        PlayerState winner = player1.score() > player2.score() ? player1 : player2;
        return "Win for " + winner.name();
    }

    @Override
    public boolean isApplicable(PlayerState player1, PlayerState player2) {
        return (player1.score() >= 4 || player2.score() >= 4) && Math.abs(player1.score() - player2.score()) >= 2;
    }

}
