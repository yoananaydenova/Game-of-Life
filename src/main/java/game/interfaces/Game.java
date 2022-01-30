package game.interfaces;

import game.exceptions.OutOfBoundGameFieldException;

public interface Game {
    void setup(int row, int column) throws OutOfBoundGameFieldException;
    void play();
    String drawGameField();
    int getGeneration();
}
