package com.akta.list;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

public class MatrixTraverse {

  public static List<Integer> zigzag(List<List<Integer>> matrix) {
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

  public static List<Integer> spiral(List<List<Integer>> matrix) {
    if (matrix == null || matrix.size() == 0) {
      return emptyList();
    }
    List<Integer> result = new ArrayList<>();
    int top = 0;
    int bottom = matrix.size() - 1;
    int left = 0;
    int right = matrix.get(0).size() - 1;
    while (top <= bottom && left <= right) {
      for (int i = left; i <= right; i++) {
        result.add(matrix.get(top).get(i));
      }
      top += 1;
      for (int i = top; i <= bottom; i++) {
        result.add(matrix.get(i).get(right));
      }
      right -= 1;
      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          result.add(matrix.get(bottom).get(i));
        }
        bottom -= 1;
      }
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          result.add(matrix.get(i).get(left));
        }
        left += 1;
      }
    }
    return result;
  }

}
