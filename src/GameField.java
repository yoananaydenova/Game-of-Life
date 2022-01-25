public class GameField {
    private int row;
    private int column;
    private int generation = 0;
    private int[][] field;

    public GameField(int row, int column) {
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

    public boolean setLiveCell(int row, int column) {
        if (row < 0 || row >= this.row) {
            // TODO throw
            System.out.println("Out of boundary ROW");
            return false;
        }
        if (column < 0 || column >= this.column) {
            // TODO throw
            System.out.println("Out of boundary COLUMN");
            return false;
        }
        this.field[row][column] = 1;
        return false;
    }

    public void createNextGeneration() {
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
        printGameField();
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


    public void printGameField() {
        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.column; col++) {
                System.out.print(this.field[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
