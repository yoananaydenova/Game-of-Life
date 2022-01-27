package game;

import game.exceptions.OutOfBoundGameFieldException;
import game.interfaces.Game;


public class GameOfLife implements Game {

    public static final int LOW_BOUND = 2;
    public static final int HIGH_BOUND = 100;
    public static final int ROW_NUMBER_DEFAULT = 10;
    public static final int COLUMN_NUMBER_DEFAULT = 10;

    private final int row;
    private final int column;
    private int generation = 0;
    private int[][] field;

    public GameOfLife(int row, int column) throws OutOfBoundGameFieldException {
        if (row < LOW_BOUND || row > HIGH_BOUND) {
            throw new OutOfBoundGameFieldException(String.format("Row size is out of bound. It must be between %s and %s.n", LOW_BOUND, HIGH_BOUND));
        }
        if (column < LOW_BOUND || column > HIGH_BOUND) {
            throw new OutOfBoundGameFieldException(String.format("Column size is out of bound. It must be between %s and %s.n", LOW_BOUND, HIGH_BOUND));
        }
        this.row = row;
        this.column = column;
        this.field = new int[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getGeneration() {
        return generation;
    }

    public int[][] getField() {
        return field;
    }

    public void setup(int row, int column) throws OutOfBoundGameFieldException {
        if (row < 0 || row >= this.row) {
            throw new OutOfBoundGameFieldException(String.format("Row is out of bound. It must be between 0 and %s inclusive. ", this.row - 1));
        }
        if (column < 0 || column >= this.column) {
            throw new OutOfBoundGameFieldException(String.format("Column is out of bound. It must be between 0 and %s inclusive. ", this.column - 1));
        }
        this.field[row][column] = 1;
    }

    public void play() {
        int[][] resultArr = new int[this.row][this.column];

        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.column; col++) {
                int liveNeighbours = getLiveNeighbours(row, col);
                // if cell is LIVE
                if (this.field[row][col] == 1 && (liveNeighbours == 2 || liveNeighbours == 3)) {
                    resultArr[row][col] = 1;
                    // if cell is DEAD
                } else if (this.field[row][col] == 0 && liveNeighbours == 3) {
                    resultArr[row][col] = 1;
                }
            }

        }
        this.generation++;
        this.field = resultArr;
    }

    private int getLiveNeighbours(int row, int col) {
        int result = 0;

        int checkRow;
        int checkCol;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r == row && c == col) {
                    continue;
                }

                if (r == -1) {
                    checkRow = this.row - 1;
                } else if (r == this.row) {
                    checkRow = 0;
                } else {
                    checkRow = r;
                }

                if (c == -1) {
                    checkCol = this.column - 1;
                } else if (c == this.column) {
                    checkCol = 0;
                } else {
                    checkCol = c;
                }

                if (this.field[checkRow][checkCol] == 1) {
                    result++;
                }
            }
        }

        return result;
    }


    public String drawGameField() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.column; col++) {

                stringBuilder.append(this.field[row][col]).append(" ");
            }
           stringBuilder.append(" \n");
        }
        return stringBuilder.toString();
    }
}
