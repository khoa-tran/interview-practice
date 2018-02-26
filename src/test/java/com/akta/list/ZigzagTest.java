package com.akta.list;

import static com.akta.list.Zigzag.getZigzag;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ZigzagTest {

  @Test
  public void getZigzag_withNull() {
    assertEquals(emptyList(), getZigzag(null));
  }

  @Test
  public void getZigzag_withEmpty() {
    assertEquals(emptyList(), getZigzag(emptyList()));
  }

  @Test
  public void getZigzag_withOnlyOneRow() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    assertEquals(asList(1, 2, 3, 4), getZigzag(matrix));
  }

  @Test
  public void getZigzag_withOnlyOneColumn() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(singletonList(1));
    matrix.add(singletonList(2));
    matrix.add(singletonList(3));
    matrix.add(singletonList(4));
    assertEquals(asList(1, 2, 3, 4), getZigzag(matrix));
  }

  @Test
  public void getZigzag_withMultipleRows_sameSize() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    matrix.add(asList(5, 6, 7, 8));
    matrix.add(asList(9, 10, 11, 12));
    assertEquals(asList(1, 2, 3, 4, 8, 7, 6, 5, 9, 10, 11, 12), getZigzag(matrix));
  }

  @Test
  public void getZigzag_withMultipleRows_differentSize() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2));
    matrix.add(asList(3, 4, 5, 6, 7));
    matrix.add(asList(8, 9, 10));
    matrix.add(asList(11, 12, 13, 14));
    assertEquals(asList(1, 2, 7, 6, 5, 4, 3, 8, 9, 10, 14, 13, 12, 11), getZigzag(matrix));
  }

  @Test
  public void getZigzag_withMultipleRows_withNullOrEmptyRows() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(null);
    matrix.add(emptyList());
    matrix.add(singletonList(1));
    assertEquals(singletonList(1), getZigzag(matrix));

    matrix.add(asList(2, 3));
    assertEquals(asList(1, 3, 2), getZigzag(matrix));

    matrix.add(emptyList());
    matrix.add(asList(4, 5, 6));
    assertEquals(asList(1, 3, 2, 4, 5, 6), getZigzag(matrix));

    matrix.add(null);
    matrix.add(null);
    matrix.add(emptyList());
    matrix.add(emptyList());
    matrix.add(null);
    matrix.add(asList(7, 8));
    assertEquals(asList(1, 3, 2, 4, 5, 6, 8, 7), getZigzag(matrix));
  }

}