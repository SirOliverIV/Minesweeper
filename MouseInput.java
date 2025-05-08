import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter implements InputStrategy {
    private final GameModel model;

    public MouseInput(GameModel model) {
        this.model = model;
    }

    @Override
    public void handleInput(GameModel model) {
        // Mouse input is already integrated into GraphicalView
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Example: Custom mouse handling logic could be implemented here
    }
}