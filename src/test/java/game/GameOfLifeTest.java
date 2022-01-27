package game;


import game.exceptions.OutOfBoundGameFieldException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game Of life")
class GameOfLifeTest {

    @Nested
    @DisplayName("constructor")
    class ConstructorTest {

        @Test
        @DisplayName("should create instance correct with low bound for row and column")
        public void constructor_GameOfLife_with_low_bound_should_create_instance_correct() {

            int row = GameOfLife.LOW_BOUND;
            int column = GameOfLife.LOW_BOUND;
            int[][] arr = new int[row][column];

            GameOfLife gameOfLife = new GameOfLife(row, column);
            assertEquals(row, gameOfLife.getRow());
            assertEquals(column, gameOfLife.getColumn());
            assertArrayEquals(arr, gameOfLife.getField());
        }

        @Test
        @DisplayName("should create instance correct with high bound for row and column")
        public void constructor_GameOfLife_with_high_bound_should_create_instance_correct() {

            int row = GameOfLife.HIGH_BOUND;
            int column = GameOfLife.HIGH_BOUND;
            int[][] arr = new int[row][column];

            GameOfLife gameOfLife = new GameOfLife(row, column);
            assertEquals(row, gameOfLife.getRow());
            assertEquals(column, gameOfLife.getColumn());
            assertArrayEquals(arr, gameOfLife.getField());
        }

        @Test
        @DisplayName("should throw with out of low bound for row")
        public void constructor_GameOfLife_with_out_of_low_bound_for_row_should_throw() {

            int row = GameOfLife.LOW_BOUND - 1;
            int column = GameOfLife.LOW_BOUND;

            String message = String.format("Row size is out of bound. It must be between %s and %s.n", GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> {
                        GameOfLife gameOfLife = new GameOfLife(row, column);
                    });

            assertEquals(message, myException.getMessage());
        }

        @Test
        @DisplayName("should throw with out of low bound for column")
        public void constructor_GameOfLife_with_out_of_low_bound_for_column_should_throw() {

            int row = GameOfLife.LOW_BOUND;
            int column = GameOfLife.LOW_BOUND-1;

            String message = String.format("Column size is out of bound. It must be between %s and %s.n", GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> {
                        GameOfLife gameOfLife = new GameOfLife(row, column);
                    });

            assertEquals(message, myException.getMessage());
        }

        @Test
        @DisplayName("should throw with out of high bound for row")
        public void constructor_GameOfLife_with_out_of_high_bound_for_row_should_throw() {

            int row = GameOfLife.HIGH_BOUND +1;
            int column = GameOfLife.HIGH_BOUND;

            String message = String.format("Row size is out of bound. It must be between %s and %s.n", GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> {
                        GameOfLife gameOfLife = new GameOfLife(row, column);
                    });

            assertEquals(message, myException.getMessage());
        }

        @Test
        @DisplayName("should throw with out of high bound for column")
        public void constructor_GameOfLife_with_out_of_high_bound_for_column_should_throw() {

            int row = GameOfLife.HIGH_BOUND;
            int column = GameOfLife.HIGH_BOUND  +1;

            String message = String.format("Column size is out of bound. It must be between %s and %s.n", GameOfLife.LOW_BOUND, GameOfLife.HIGH_BOUND);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> {
                        GameOfLife gameOfLife = new GameOfLife(row, column);
                    });

            assertEquals(message, myException.getMessage());
        }
    }

    @Test
    @DisplayName("should return correct generation")
    public void getGeneration_should_return_correct_generation() {

        int row = GameOfLife.HIGH_BOUND;
        int column = GameOfLife.HIGH_BOUND;

        GameOfLife gameOfLife = new GameOfLife(row, column);

        assertEquals(0, gameOfLife.getGeneration());

        gameOfLife.play();

        assertEquals(1, gameOfLife.getGeneration());

        gameOfLife.play();

        assertEquals(2, gameOfLife.getGeneration());

    }

    @Nested
    @DisplayName("setup method")
    class setupTest {

        @Test
        @DisplayName("should set live cell correct")
        public void setup_should_set_live_cell_correct() {

            int rowSize = GameOfLife.LOW_BOUND;
            int columnSize = GameOfLife.LOW_BOUND;
            int[][] arr = new int[rowSize][columnSize];

            arr[rowSize-1][rowSize-1] = 1;

            GameOfLife gameOfLife = new GameOfLife(rowSize, columnSize);
            gameOfLife.setup(rowSize-1,rowSize-1);
            assertArrayEquals(arr, gameOfLife.getField());
        }

        @Test
        @DisplayName("should throw with out of bound below zero for row")
        public void setup_should_throw_with_out_of_bound_below_zero_for_row() {

            int row = GameOfLife.LOW_BOUND;
            int column = GameOfLife.LOW_BOUND;

            String message = String.format("Row is out of bound. It must be between 0 and %s inclusive. ", row - 1);
            GameOfLife gameOfLife = new GameOfLife(row, column);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> gameOfLife.setup(-1, 0));

            assertEquals(message, myException.getMessage());
        }

        @Test
        @DisplayName("should throw with out of bound below zero for column")
        public void setup_should_throw_with_out_of_bound_below_zero_for_column() {

            int row = GameOfLife.LOW_BOUND;
            int column = GameOfLife.LOW_BOUND;

            String message = String.format("Column is out of bound. It must be between 0 and %s inclusive. ", column - 1);
            GameOfLife gameOfLife = new GameOfLife(row, column);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> gameOfLife.setup(0, -1));

            assertEquals(message, myException.getMessage());
        }

        @Test
        @DisplayName("should throw with out of bound above top bound for row")
        public void setup_should_throw_with_out_of_bound_above_top_bound_for_row() {

            int row = GameOfLife.LOW_BOUND;
            int column = GameOfLife.LOW_BOUND;

            String message = String.format("Row is out of bound. It must be between 0 and %s inclusive. ", row - 1);
            GameOfLife gameOfLife = new GameOfLife(row, column);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> gameOfLife.setup(row, 0));

            assertEquals(message, myException.getMessage());
        }

        @Test
        @DisplayName("should throw with out of bound above top bound for column")
        public void setup_should_throw_with_out_of_bound_above_top_bound_for_column() {

            int row = GameOfLife.LOW_BOUND;
            int column = GameOfLife.LOW_BOUND;

            String message = String.format("Column is out of bound. It must be between 0 and %s inclusive. ", column - 1);
            GameOfLife gameOfLife = new GameOfLife(row, column);

            OutOfBoundGameFieldException myException = assertThrows(OutOfBoundGameFieldException.class,
                    () -> gameOfLife.setup(0, column));

            assertEquals(message, myException.getMessage());
        }

    }



        @Test
        @DisplayName("should return correct game field string with method drawGameField")
        public void drawGameField_should_return_correct_string_generation() {

            int row = GameOfLife.LOW_BOUND;
            int column = GameOfLife.LOW_BOUND;
            int[][] arr = new int[row][column];

            arr[row-1][row-1] = 1;

            GameOfLife gameOfLife = new GameOfLife(row, column);
            gameOfLife.setup(row-1,column-1);

            assertEquals(helperDrawGameField(arr), gameOfLife.drawGameField());
        }

    private  String helperDrawGameField(int [][]arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                stringBuilder.append(arr[row][col]).append(" ");
            }
            stringBuilder.append(" \n");
        }
        return stringBuilder.toString();
    }

}