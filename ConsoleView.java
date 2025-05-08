public class ConsoleView implements GameObserver {
    private final GameModel model;

    public ConsoleView(GameModel model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(GameModel model) {
        // Print the board state to the console
    }
}