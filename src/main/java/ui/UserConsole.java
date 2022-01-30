package ui;

import game.IntPair;
import game.exceptions.OutOfBoundGameFieldException;
import game.interfaces.Game;
import ui.interfaces.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserConsole implements User {

    private static final Scanner scanner = new Scanner(System.in);
   private final Game game;

    public UserConsole(Game game) {
        this.game = game;
    }

    public static int getGameFieldDimension(String nameOfDimension, int lowBound, int highBound) {
        int dimensionSize = -1;
        do {
            System.out.printf("Enter %s of the game filed /number must be between %d inclusive and %d inclusive/:%n", nameOfDimension, lowBound, highBound);
            String dimensionSizeStr = scanner.nextLine();
            try {
                dimensionSize = Integer.parseInt(dimensionSizeStr);
                if(dimensionSize < lowBound || dimensionSize > highBound){
                    System.out.printf("The number %d is out of bound. It must be between %d inclusive and %d inclusive:%n", dimensionSize, lowBound, highBound);
                }
            } catch (NumberFormatException e) {
                System.out.print("The data type of input is incorrect. ");
            }
        } while (dimensionSize < lowBound || dimensionSize > highBound);

        return dimensionSize;
    }

    public List<IntPair> getInitialGameState() {
        List<IntPair> listOfCoordinates = new ArrayList<>();
        System.out.printf("Enter coordinates of the live cells in format \"row,column\" /1 ~ %d inclusive for row and 1 ~ %d inclusive for column/. Enter F when you are finish.%n", game.getRow(), game.getColumn());

        String rowColumnInput = scanner.nextLine();
        while (!rowColumnInput.toUpperCase().equals("F")) {
            String[] rowAndColumnStr = rowColumnInput.trim().split("\\s*,\\s*");
            if (rowAndColumnStr.length == 2) {
                try {
                    int row = Integer.parseInt(rowAndColumnStr[0]);
                    int column = Integer.parseInt(rowAndColumnStr[1]);

                    listOfCoordinates.add(new IntPair(row, column));
                }catch (NumberFormatException e){
                    System.out.print("Incorrect format of input. Try again! ");
                } catch (OutOfBoundGameFieldException e) {
                    System.out.print(e.getMessage());
                }

            } else {
                System.out.print("Incorrect format of input. Try again! ");
            }

            System.out.printf("Enter coordinates of the live cells in format \"row,column\" /1 ~ %d inclusive for row and 1 ~ %d inclusive for column/. Enter F when you are finish.%n", game.getRow(), game.getColumn());
            rowColumnInput = scanner.nextLine();
        }

        return listOfCoordinates;
    }


    public void startGame() {
        System.out.println("Enter N for \"Next generation\" and E for \"Exit from program\".");
        String nextGenerationInput = scanner.nextLine();

        while (!nextGenerationInput.toUpperCase().equals("E")) {

            if (nextGenerationInput.toUpperCase().equals("N")) {
                game.play();
                System.out.println("Generation No " + game.getGeneration() + " :\n");
                System.out.println(game.drawGameField());
            }else {
                System.out.print("Incorrect format of input. Try again! ");
            }

            System.out.println("Enter N for \"Next generation\" and E for \"Exit from program\".");
            nextGenerationInput = scanner.nextLine();
        }
    }


}


