import java.util.Scanner;

public class KeyboardInput implements InputStrategy {
    @Override
    public void handleInput(GameModel model) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command (r row col to reveal, f row col to flag):");
        String command = scanner.next();
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (command.equals("r")) {
            model.revealCell(row, col);
        } else if (command.equals("f")) {
            model.flagCell(row, col);
        }
    }
}