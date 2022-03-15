package net.xeill.elpuig;

import java.io.*;
import java.util.*;

/**
* This class implements the Bomberman Utils.
*
* @author  Rusben
*/

public class Utils {

  public int randomInt(int min, int max) {
    Random random = new Random();
    int randomNumber = random.nextInt(max + 1 - min) + min;

    return randomNumber;
  }

}
