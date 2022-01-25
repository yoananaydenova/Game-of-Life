import java.util.Scanner;
//  Any live cell with two or three live neighbours survives.
//  Any dead cell with three live neighbours becomes a live cell.
//  All other live cells die in the next generation. Similarly, all other dead cells stay dead.
// live -> 1
// dead -> 0

// TODO: exception handling for: Integer.parseInt
// TODO: check variable names

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

        int[][] initialArr = new int[rowSize][columnSize];
        printMatrix(initialArr);

        // Set the dead cells
        System.out.println("Enter coordinates of the live cells in format \"row-column\". Enter F when you are finish.");

        String rowColumnInput = scanner.nextLine();
        while (!rowColumnInput.equals("F")){
            String[] rowAndColumnStr = rowColumnInput.trim().split("-");
            if(rowAndColumnStr.length == 2){
                int row = Integer.parseInt(rowAndColumnStr[0]);
                int column = Integer.parseInt(rowAndColumnStr[1]);
                initialArr[row][column] = 1;
            }

            System.out.println("Enter coordinates of the live cells in format \"row-column\". Enter F when you are finish.");
            rowColumnInput = scanner.nextLine();
        }

        System.out.println("Field of game:");
        printMatrix(initialArr);

        // Start to create the next generation
        System.out.println("Enter N for Next generation and E for Exit from program");
        String input = scanner.nextLine();

        while (!input.equals("e")) {

            initialArr = createNextGeneration(initialArr);

            System.out.println("Print next generation");
            printMatrix(initialArr);

            System.out.println("Enter n for Next generation and e for Exit of program");
            input = scanner.nextLine();
        }

    }

    private static int[][] createNextGeneration(int[][] initialArr) {
        return null;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
