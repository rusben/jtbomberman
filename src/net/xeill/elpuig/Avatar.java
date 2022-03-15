package net.xeill.elpuig;

import java.io.*;
import java.util.*;

/**
* This class implements the Bomberman Avatar.
*
* @author  Rusben
*/

public abstract class Avatar {
  int x;
  int y;
  String name;

  Avatar(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }

  @Override
  public String toString() {
      return (this.name).substring(0, 1);
      //return "ȫ";
  }

}
