package net.xeill.elpuig;

import java.util.*;
import java.io.*;

/**
* This class implements the Main.
*
* <p>The methods of this class all throw a <tt>NullPointerException</tt>
* if the collections or class objects provided to them are null.
*
*
* @author  Rusben
*/
public class Main {
  public static void main(String[] args) {

    UserInterface ui = new UserInterface();
    Board b = new Board(10, 10);
    Game game = new Game(b, 5);

    // Init the game
    game.start();

    // Loops until the game is over
    while (!game.isOver()) {

      ui.showBoard(game.board);

      ui.sleep(5);

      ui.clearScreen();

      ui.showYouLoose();

      ui.sleep(5);

      ui.clearScreen();

    }


    /*System.out.println("Hello world!");
    b.print();

    input.nextInt();

    b.clear();


*/





  }
}
