package com.rpn.utils;

public class NumberUtils {
  public static String numberToString(double num) {
    String string;
    if (num == Math.floor(num) && !Double.isInfinite(num)) {
      int intNum = (int)num;
      string = String.valueOf(intNum);
    } else {
      string = String.valueOf(num);
    }
    return string;
  }

  public static boolean isNumber(String string) {
    return org.apache.commons.lang3.math.NumberUtils.isCreatable(string);
  }
}
