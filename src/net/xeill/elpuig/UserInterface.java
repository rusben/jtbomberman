package net.xeill.elpuig;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit ;

/**
* This class implements the Bomberman UI, User Interface.
*
* @author  Rusben
*/

public class UserInterface {

  Scanner scanner = new Scanner(System.in);

  /**
  * Clears the screen.
  */
  void clearScreen() {
    System.out.print("\033\143");
  }

  /**
  * Shows the "YOU LOOSE" message
  */
  void showYouLoose() {
    System.out.println("\n\033[30;101m" +
                "  ╦ ╦╔═╗╦ ╦  ╦  ╔═╗╔═╗╔═╗  \n" +
                "  ╚╦╝║ ║║ ║  ║  ║ ║╚═╗║╣   \n" +
                "   ╩ ╚═╝╚═╝  ╩═╝╚═╝╚═╝╚═╝  \033[0m");
  }

  /**
  * Shows the "YOU WIN" message
  */
  void showYouWin(){
    System.out.println("\n\033[30;102m" +
              "  ╦ ╦╔═╗╦ ╦  ╦ ╦ ╦ ╔╗╔  \n" +
              "  ╚╦╝║ ║║ ║  ║║║ ║ ║║║  \n" +
              "   ╩ ╚═╝╚═╝  ╚╩╝ ╩ ╝╚╝  \033[0m");
  }

  /**
  * Shows the game board
  */
  void showBoard(Board b) {
    b.print();
  }

  void pressAnyKey(){
    scanner.nextLine();
  }

  /**
  * Pauses the game interaction during seconds
  */
  public void sleep(int seconds) {

    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (Exception e) {

    }
  }






}
