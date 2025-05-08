public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int neighboringMines;

    public Cell(boolean isMine) {
        this.isMine = isMine;
        this.isRevealed = false;
        this.isFlagged = false;
        this.neighboringMines = 0;
    }

    public boolean isMine() {
        return isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        isRevealed = true;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void toggleFlag() {
        isFlagged = !isFlagged;
    }

    public int getNeighboringMines() {
        return neighboringMines;
    }

    public void setNeighboringMines(int neighboringMines) {
        this.neighboringMines = neighboringMines;
    }
}