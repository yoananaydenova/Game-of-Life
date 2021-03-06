import game.GameOfLife;
import game.IntPair;
import game.exceptions.OutOfBoundGameFieldException;
import game.interfaces.Game;
import ui.UserConsole;

import java.util.List;

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
            System.out.println(e.getMessage());
            System.out.printf("There was a problem creating a game field. It's created by default with dimensions: %d rows and %d columns.", GameOfLife.ROW_NUMBER_DEFAULT, GameOfLife.COLUMN_NUMBER_DEFAULT);
        }

        // Set the live cells
        UserConsole userConsole = new UserConsole(game);

        List<IntPair> initialGameStateCoordinates = userConsole.getInitialGameState();
        for (IntPair pair : initialGameStateCoordinates) {
            game.setup(pair.getRow() - 1, pair.getColumn() - 1);
        }
        System.out.println();
        System.out.println("INITIAL FIELD OF GAME");
        System.out.println("Generation No " + game.getGeneration() + " :\n");
        System.out.println(game.drawGameField());

       // Start to create the next generation
        userConsole.startGame();

    }

}
