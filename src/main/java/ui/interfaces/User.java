package ui.interfaces;

import game.IntPair;
import game.interfaces.Game;

import java.util.List;

public interface User {

    List<IntPair> getInitialGameState();
    void startGame();
}
