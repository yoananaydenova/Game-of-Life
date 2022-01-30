# Game-of-Life

This is an implementation of Conway's Game of Life.

Rules of the game:
1. Any live cell with two or three live neighbours survives.
2. Any dead cell with three live neighbours becomes a live cell.
3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.


- You can run the game as a standard java program.
- The game interface is console.
- The playing field consists of rows and columns that are limited from 2 to 100 and filled with cells. 
- Each cell exists in one of two possible states - live or dead.
- The game is played by a single player who first selects the dimensions of the field and then enters the coordinates of the living cells.
- After starting the game, the player declares the generation of each subsequent generation, which obeys the rules described above.
- The next generation will appear on the console, with living cells marked with 1 (one) and dead with 0 (zero).
