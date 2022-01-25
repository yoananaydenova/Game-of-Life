//  Any live cell with two or three live neighbours survives.
//  Any dead cell with three live neighbours becomes a live cell.
//  All other live cells die in the next generation. Similarly, all other dead cells stay dead.
// live -> 1
// dead -> 0

// TODO: exception handling for: Integer.parseInt, index out of bound
// TODO: check variable names

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create game filed
        System.out.println("Enter row of the filed:");
        String rowSizeStr = scanner.nextLine();

        System.out.println("Enter column of the filed:");
        String columnSizeStr = scanner.nextLine();

        int rowSize = Integer.parseInt(rowSizeStr);
        int columnSize = Integer.parseInt(columnSizeStr);

        GameField gameField = new GameField(rowSize, columnSize);
        System.out.println("Initial field of game:");
        gameField.printGameField();

        // Set the live cells
        System.out.println("Enter coordinates of the live cells in format \"row,column\". Enter F when you are finish.");

        String rowColumnInput = scanner.nextLine();
        while (!rowColumnInput.toUpperCase().equals("F")) {
            String[] rowAndColumnStr = rowColumnInput.trim().split(",");
            if (rowAndColumnStr.length == 2) {
                int row = Integer.parseInt(rowAndColumnStr[0]);
                int column = Integer.parseInt(rowAndColumnStr[1]);

                gameField.setLiveCell(row, column);
            }

            System.out.println("Enter coordinates of the live cells in format \"row,column\". Enter F when you are finish.");
            rowColumnInput = scanner.nextLine();
        }

        System.out.println("Field of game:");
        gameField.printGameField();


        // Start to create the next generation
        System.out.println("Enter N for Next generation and E for Exit from program");
        String nextGenerationInput = scanner.nextLine();

        while (!nextGenerationInput.toUpperCase().equals("E")) {

            System.out.println("Generation No " + gameField.getGeneration() + " :");
            gameField.createNextGeneration();

            System.out.println("Enter N for Next generation and e for Exit of program");
            nextGenerationInput = scanner.nextLine();
        }

    }

}
