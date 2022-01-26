package game.interfaces;

import game.exceptions.OutOfBoundGameFieldException;

public interface Game {
    void setup(int row, int column) throws OutOfBoundGameFieldException;
    void play();
    void drawGameField();

    // TODO: this should be gone...but how???
    int getRow();
    int getColumn();
}
