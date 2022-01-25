package game.interfaces;

import game.exceptions.OutOfBoundGameFieldException;

public interface GameOfLife {
    void setLiveCell(int row, int column) throws OutOfBoundGameFieldException;
    void createNextGeneration();
    int getRow();
    int getColumn();
}
