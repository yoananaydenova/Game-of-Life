import game.GameOfLife;
import game.exceptions.OutOfBoundGameFieldException;

import java.util.Scanner;

public class GameEngine {

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        // Create game filed
        int rowSize = createGameFieldSize("row", scanner);
        int columnSize = createGameFieldSize("column", scanner);

        try {
            // Create game
            GameOfLife gameOfLife = new GameOfLife(rowSize, columnSize);
            // Set the live cells
            initialLiveCellCoordinates(gameOfLife, scanner);
            // Start to create the next generation
            startGameOfLife(gameOfLife, scanner);
        } catch (OutOfBoundGameFieldException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void startGameOfLife(GameOfLife gameOfLife, Scanner scanner) {
        System.out.println("Enter N for Next generation and E for Exit from program");
        String nextGenerationInput = scanner.nextLine();

        while (!nextGenerationInput.toUpperCase().equals("E")) {

            if (nextGenerationInput.toUpperCase().equals("N")) {
                gameOfLife.createNextGeneration();
            }else {
                System.out.print("Incorrect format of input. Try again! ");
            }

            System.out.println("Enter N for \"Next generation\" and E for \"Exit from program.\"");
            nextGenerationInput = scanner.nextLine();
        }
    }

    private static void initialLiveCellCoordinates(GameOfLife gameOfLife, Scanner scanner) {
        System.out.printf("Enter coordinates of the live cells in format \"row,column\" /0 ~ %d inclusive for row and 0 ~ %d inclusive for column/. Enter F when you are finish.%n", gameOfLife.getRow(), gameOfLife.getColumn());

        String rowColumnInput = scanner.nextLine();
        while (!rowColumnInput.toUpperCase().equals("F")) {
            String[] rowAndColumnStr = rowColumnInput.trim().split("\\s*,\\s*");
            if (rowAndColumnStr.length == 2) {

                try {
                    int row = Integer.parseInt(rowAndColumnStr[0]);
                    int column = Integer.parseInt(rowAndColumnStr[1]);
                    gameOfLife.setLiveCell(row, column);
                }catch (NumberFormatException e){
                    System.out.print("Incorrect format of input. Try again! ");
                } catch (OutOfBoundGameFieldException e) {
                    System.out.print(e.getMessage());
                }

            } else {
                System.out.print("Incorrect format of input. Try again! ");
            }

            System.out.println("Enter coordinates of the live cells in format \"row,column\". Enter F when you are finish.");
            rowColumnInput = scanner.nextLine();
        }

        System.out.println();
        System.out.println("INITIAL FIELD OF GAME");
        gameOfLife.printField();
    }

    private static int createGameFieldSize(String nameOfDimension, Scanner scanner) {
        int dimensionSize = -1;
        do {
            System.out.printf("Enter %s of the game filed /number must be between %d inclusive and %d inclusive/:%n", nameOfDimension, GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);
            String dimensionSizeStr = scanner.nextLine();
            try {
                dimensionSize = Integer.parseInt(dimensionSizeStr);
                if(dimensionSize < GameOfLife.LOW_BOUND || dimensionSize > GameOfLife.HIGH_BOUND){
                    System.out.printf("The number %d is out of bound. It must be between %d inclusive and %d inclusive:%n", dimensionSize, GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);
                }
            } catch (NumberFormatException e) {
                System.out.print("The data type of input is incorrect. ");
            }
        } while (dimensionSize < GameOfLife.LOW_BOUND || dimensionSize > GameOfLife.HIGH_BOUND);

        return dimensionSize;
    }
}
