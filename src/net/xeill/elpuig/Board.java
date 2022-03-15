package net.xeill.elpuig;

import java.io.*;
import java.util.*;

/**
* This class implements the Bomberman Board.
*
* <p>The methods of this class all throw a <tt>NullPointerException</tt>
* if the collections or class objects provided to them are null.
*
*
* @author  Rusben
*/


public class Board {

    Avatar[][] matrix;
    int rows;
    int columns;

    /**
     * Creates the Board with the indicated size.
     *
     * @param  rows the number of rows in the board.
     * @param  columns the number of columns in the board.
     *
     */
    public Board(int rows, int columns) {
      this.rows = rows;
      this.columns = columns;
      this.matrix = new Avatar[rows][columns];
    }

    /**
    * Indicates whether a tile in the board is empty.
    *
    * @return A {@code null} value whether the coordinates are out of bounds.
    *         If the tile is empty returns {@code true}, otherwise {@code false}.
    */
    public boolean emptyTile(int x, int y) {

      if (x >= 0 && x < rows && y >= 0 && y < columns) {
        if (matrix[x][y] == null) return true;
        else return false;
      }

      return false;
    }

    /**
    * Indicates which type of avatar is in the given coordinates.
    *
    * @return A {@code -1} value whether the coordinates are out of bounds.
    *         If the tile is empty returns {@code 0}, if there is a player
    *         {@code 1}, if there is an enemy {@code 2}, if there is a bomb
    *         {@code 3}
    */
    public Avatar who(int x, int y) {

      if (x >= 0 && x < rows && y >= 0 && y < columns) {
        return matrix[x][y];
      }

      return null;
    }

    /**
    * Adds the Avatar a into the position x, y in the Board
    *
    * @return A {@code true} value whether the Avatar is placed in the given
    *         coordinates, {@code false}, if there is a bomb
    *         {@code 3} otherwise
    */
    public boolean addAvatar(Avatar a, int x, int y) {

      if (emptyTile(x,y)) {
        // Añado el Avatar a a la posición x, y
        matrix[x][y] = a;
        return true;
      }

      // No he podido añadir el Avatar
      return false;

    }

// https://theasciicode.com.ar/extended-ascii-code/black-square-ascii-code-254.html
// ASCII code 185 = ╣ ( Box drawing character double line vertical and left )
// ASCII code 186 = ║ ( Box drawing character double vertical line )
// ASCII code 187 = ╗ ( Box drawing character double line upper right corner )
// ASCII code 188 = ╝ ( Box drawing character double line lower right corner )
// ASCII code 200 = ╚ ( Box drawing character double line lower left corner )
// ASCII code 201 = ╔ ( Box drawing character double line upper left corner )
// ASCII code 202 = ╩ ( Box drawing character double line horizontal and up )
// ASCII code 203 = ╦ ( Box drawing character double line horizontal down )
// ASCII code 204 = ╠ ( Box drawing character double line vertical and right )
// ASCII code 205 = ═ ( Box drawing character double horizontal line )
// ASCII code 206 = ╬ ( Box drawing character double line horizontal vertical )

    public void clear() {
      // Clear the screen
      try {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      } catch (Exception e) {
        System.out.println(e);
      }

    }

    /**
    * Prints the board.
    */
    public void print() {

      for (int i = 0; i < rows; i++) {
        System.out.print((i == 0) ? "╔" : "╠");

        for (int k = 0; k < 4*columns - 1; k++) {
          System.out.print((k != 0 && ((k+1) % 4 == 0)) ? ((i == 0) ? "╦" : "╬") : "═");
        }

        System.out.println((i == 0) ? "╗" : (i == rows) ? "╝" : "╣");

        for (int j = 0; j < columns; j++) {
          System.out.print("║");

          for (int k = 0; k < 1; k++) System.out.print(" ");

          System.out.print((matrix[i][j] != null) ? matrix[i][j] : " ");

          for (int k = 0; k < 1; k++) System.out.print(" ");

        }
        System.out.println("║");
      }

      System.out.print("╚");

      for (int k = 0; k < 4*columns - 1; k++) {
        System.out.print((k != 0 && ((k+1) % 4 == 0)) ? "╩" : "═");
      }

      System.out.print("╝");

    }


}
