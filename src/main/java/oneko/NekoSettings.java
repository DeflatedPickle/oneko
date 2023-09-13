/*
 * Copyright (c) 2023 DeflatedPickle
 * Copyright (c) 2019 Jerry Reno
 *
 * This is public domain software, under the terms of the UNLICENSE
 * http://unlicense.org
 */

package oneko;

public class NekoSettings {
  public int getTriggerDist() {
    return 64;
  }

  public int getCatchDist() {
    return 2;
  }

  public int getRunDist() {
    return 16;
  }

  public int getOffsetX() {
    return -2;
  }

  public int getOffsetY() {
    return -3;
  }

  public int getRunDelay() {
    return 1000 / 8;
  }

  public int getSitDelay() {
    return 1000 / 3;
  }

  public int getScratchDelay() {
    return 1000 / 10;
  }

  public int getSharpenDelay() {
    return 1000 / 3;
  }

  public int getLoadDelay() {
    return 1000 / 20;
  }

  public int getSleepDelay() {
    return 1200;
  }

  public int getYawnDelay() {
    return 1500;
  }

  public int getSurpriseDelay() {
    return 1000;
  }
}
