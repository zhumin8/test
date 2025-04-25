package com.example.lib;

import static com.example.lib.Main.isClassInPath;

public class Checker {

  public static boolean checkIfV1LocationNamePresent() {
    if (isClassInPath("com.google.cloud.workflows.v1.LocationName")) {
      System.out.println("Yes! v1.LocationName is accessible");
      return true;
    } else {
      System.out.println("NO! cannot find v1.LocationName");
      return false;
    }
  }
}
