import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private final int rows;
    private final int cols;
    private final int mineCount;
    private Cell[][] board;
    private boolean gameOver;
    private boolean gameWon;
    private final List<GameObserver> observers = new ArrayList<>();

    public GameModel(int rows, int cols, int mineCount) {
        this.rows = rows;
        this.cols = cols;
        this.mineCount = mineCount;
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = new Cell(false); // Default to no mines
            }
        }
        // Randomly place mines (not implemented here for brevity)
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public void revealCell(int row, int col) {
        if (board[row][col].isRevealed() || board[row][col].isFlagged()) {
            return; // Ignore if already revealed or flagged
        }
        board[row][col].reveal(); // Mark the cell as revealed

        // Check for mine, and handle logic for cascading reveals if no neighboring mines
        notifyObservers();
    }

    public void flagCell(int row, int col) {
        if (board[row][col].isRevealed()) {
            return; // Cannot flag a revealed cell
        }
        board[row][col].toggleFlag(); // Toggle flagged state
        notifyObservers();
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(this);
        }
    }
}