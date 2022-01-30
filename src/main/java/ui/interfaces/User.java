package ui.interfaces;

import game.IntPair;


import java.util.List;

public interface User {

    List<IntPair> getInitialGameState();
    void startGame();
}
