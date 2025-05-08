public class Main {
    public static void main(String[] args) {
        // Initialize game model with 10x10 grid and 20 mines
        GameModel model = new GameModel(10, 10, 20);

        // Add graphical view
        new GraphicalView(model);

        // Add console view for debugging (optional)
        new ConsoleView(model);
    }
}