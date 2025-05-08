import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicalView extends JFrame implements GameObserver {
    private final GameModel model;
    private JButton[][] buttons; // Store buttons in a 2D array

    public GraphicalView(GameModel model) {
        this.model = model;
        model.addObserver(this);
        setupUI();
    }

    private void setupUI() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JPanel grid = new JPanel(new GridLayout(model.getRows(), model.getCols()));
        buttons = new JButton[model.getRows()][model.getCols()];

        for (int row = 0; row < model.getRows(); row++) {
            for (int col = 0; col < model.getCols(); col++) {
                JButton button = new JButton();
                buttons[row][col] = button;
                grid.add(button);

                int finalRow = row;
                int finalCol = col;

                // Use mousePressed to ensure single-click interaction
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            model.flagCell(finalRow, finalCol); // Flag cell on right-click
                        } else if (SwingUtilities.isLeftMouseButton(e)) {
                            model.revealCell(finalRow, finalCol); // Reveal cell on left-click
                        }
                    }
                });
            }
        }
        add(grid);
        setVisible(true);
    }

    @Override
    public void update(GameModel model) {
        for (int row = 0; row < model.getRows(); row++) {
            for (int col = 0; col < model.getCols(); col++) {
                JButton button = buttons[row][col];
                Cell cell = model.getCell(row, col);

                if (cell.isRevealed()) {
                    if (cell.isMine()) {
                        button.setText("M"); // Display 'M' for mines
                        button.setBackground(Color.RED); // Optional: Highlight mines
                    } else {
                        button.setText(String.valueOf(cell.getNeighboringMines()));
                        button.setBackground(Color.LIGHT_GRAY);
                    }
                    button.setEnabled(false); // Disable revealed cells
                } else if (cell.isFlagged()) {
                    button.setText("F"); // Display 'F' for flagged cells
                    button.setBackground(Color.YELLOW);
                } else {
                    button.setText(""); // Reset for unrevealed cells
                    button.setBackground(null); // Reset background
                }
            }
        }
    }
}