package com.akta.list;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

public class Zigzag {

  public static List<Integer> getZigzag(List<List<Integer>> matrix) {
    if (matrix == null || matrix.size() == 0) {
      return emptyList();
    }
    List<Integer> result = new ArrayList<>();
    boolean naturalOrder = true;
    for (List<Integer> row : matrix) {
      if (row != null && row.size() > 0) {
        int numCol = row.size();
        if (naturalOrder) {
          result.addAll(row);
          naturalOrder = false;
        } else {
          for (int j = numCol - 1; j >= 0; j--) {
            result.add(row.get(j));
          }
          naturalOrder = true;
        }
      }
    }
    return result;
  }

}
