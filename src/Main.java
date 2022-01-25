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

        int[][] initialArr = new int[rowSize][columnSize];
        printMatrix(initialArr);

        // set the dead cells
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
        printMatrix(initialArr);




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
