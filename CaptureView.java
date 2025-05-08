import java.util.ArrayList;
import java.util.List;

public class CaptureView implements GameObserver {
    private final List<GameModel> gameStates = new ArrayList<>();

    @Override
    public void update(GameModel model) {
        // Record the game state (deep copy if necessary)
        gameStates.add(model);
    }

    public List<GameModel> getCapturedStates() {
        return gameStates;
    }
}