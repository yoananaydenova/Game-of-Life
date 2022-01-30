//  Any live cell with two or three live neighbours survives.
//  Any dead cell with three live neighbours becomes a live cell.
//  All other live cells die in the next generation. Similarly, all other dead cells stay dead.
// live -> 1
// dead -> 0

public class Main {
    public static void main(String[] args) {
        try {
            GameEngine.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
