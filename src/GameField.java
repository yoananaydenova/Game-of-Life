public class GameField {
    private int row;
    private int column;
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

    public boolean setLiveCell(int row, int column){
        if(row < 0 || row >= this.row ){
            System.out.println("Out of boundury ROW");
            return false;
        }
        if(column < 0 || column >= this.column ){
            System.out.println("Out of boundury COLUMN");
            return false;
        }
        this.field[row][column] = 1;
        return false;
    }

    public void  createNextGeneration() {
        int[][] resultArr = new int[this.row][this.column];

        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.column; col++) {

                // if cell is LIVE
                if (this.field[row][col] == 1) {
                    int liveNeighbours = getLiveNeighbours();
                    if(liveNeighbours == 2 || liveNeighbours == 3){
                        resultArr[row][col] = 1;
                    }

                    // if cell is DEAD
                } else if (this.field[row][col] == 0) {
                    int liveNeighbours = getLiveNeighbours();

                    if(liveNeighbours == 3){
                        resultArr[row][col] = 1;
                    }
                }
            }

        }
        this.field = resultArr;
        printGameField();
    }

    private int getLiveNeighbours() {
        return 0;
    }


    public void printGameField(){
        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.column; col++) {
                System.out.print(this.field[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
