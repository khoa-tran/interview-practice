package com.akta.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  public static int simple(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("input must be positive integer");
    }
    if (n == 1 || n == 2) {
      return 1;
    }
    return simple(n - 1) + simple(n - 2);
  }

  public static int memoized(int n) {
    return memoized(n, new HashMap<>());
  }

  private static int memoized(int n, Map<Integer, Integer> dictionary) {
    if (n <= 0) {
      throw new IllegalArgumentException("input must be positive integer");
    }
    if (dictionary.containsKey(n)) {
      return dictionary.get(n);
    }
    int result;
    if (n == 1 || n == 2) {
      result = 1;
    } else {
      result = memoized(n - 1, dictionary) + memoized(n - 2, dictionary);
    }
    dictionary.put(n, result);
    return result;
  }

}
