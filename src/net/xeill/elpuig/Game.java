package net.xeill.elpuig;

import java.io.*;
import java.util.*;

/**
* This class implements the Bomberman Game.
*
* @author  Rusben
*/

public class Game {

  boolean playing;
  boolean paused;
  boolean end;
  Board board;
  int nEnemies;
  Utils utils = new Utils();

  /**
  * Create the game with the associated board
  */
  Game(Board board, int nEnemies) {
    this.board = board;
    this.nEnemies = nEnemies;
  }

  public void initialize() {

    Player p = new Player(0, 0, "Ѫ");
    Bomb a = new Bomb(4, 5, "ȫ");

    // Añadimos el player al juego
    addAvatarToGame(p);

    // Añadimos los enemigos
    for (int i = 0; i < nEnemies; i++) {
      addAvatarToGame(randomXYEnemy());
    }

    // Añadimos la bomba
    addAvatarToGame(a);

  }

  public Enemy randomXYEnemy() {
    int x = utils.randomInt(0, board.rows - 1);
    int y = utils.randomInt(0, board.columns - 1);
    Enemy e = new Enemy(x, y, "Ӂ");

    return e;
  }

  public void addAvatarToGame(Avatar a) {
    this.board.addAvatar(a, a.x, a.y);
  }

  /**
  * Starts the game
  */
  public void start() {
    this.playing = true;
    this.paused = false;
    this.end = false;

    initialize();
  }

  /**
  * Pauses the game
  */
  public void pause() {
    this.playing = false;
    this.paused = true;
    this.end = false;
  }

  /**
  * Resumes the game
  */
  public void resume() {
    this.playing = true;
    this.paused = false;
    this.end = false;
  }

  /**
  * Finishes the game
  */
  public void end() {
    this.playing = false;
    this.paused = false;
    this.end = true;
  }

  /**
  * Indicates whether the game is over
  */
  public boolean isOver() {
    return this.end;
  }

  



}
