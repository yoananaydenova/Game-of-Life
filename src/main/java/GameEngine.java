import game.GameOfLife;
import game.exceptions.OutOfBoundGameFieldException;
import game.interfaces.Game;
import ui.UserConsole;

public class GameEngine {

    public static void start() {

        // Create game filed
        int rowSize = UserConsole.getGameFieldDimension("row", GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);
        int columnSize = UserConsole.getGameFieldDimension("column", GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);

        Game game;
        try {
            // Create game
            game = new GameOfLife(rowSize, columnSize);

        } catch (OutOfBoundGameFieldException e) {
            // Create game with default dimensions
            game = new GameOfLife(GameOfLife.ROW_NUMBER_DEFAULT, GameOfLife.COLUMN_NUMBER_DEFAULT);
            System.out.printf("There was a problem creating a game field. It's created by default with dimensions: %d rows and %d columns.", game.getRow(), game.getColumn());
            System.out.println(e.getMessage());
        }

        // Set the live cells
        UserConsole userConsole = new UserConsole(game);

        userConsole.setInitialGameState();
        // Start to create the next generation
        userConsole.startGame();

    }

}
