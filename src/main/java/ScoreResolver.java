public interface ScoreResolver {

    String resolve(PlayerState player1, PlayerState player2);

    boolean isApplicable(PlayerState player1, PlayerState player2);

}