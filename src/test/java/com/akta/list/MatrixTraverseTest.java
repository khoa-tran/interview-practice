package com.akta.list;

import static com.akta.list.MatrixTraverse.spiral;
import static com.akta.list.MatrixTraverse.zigzag;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MatrixTraverseTest {

  @Test
  public void zigzag_withNull() {
    assertEquals(emptyList(), zigzag(null));
  }

  @Test
  public void zigzag_withEmpty() {
    assertEquals(emptyList(), zigzag(emptyList()));
  }

  @Test
  public void zigzag_withOnlyOneRow() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    assertEquals(asList(1, 2, 3, 4), zigzag(matrix));
  }

  @Test
  public void zigzag_withOnlyOneColumn() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(singletonList(1));
    matrix.add(singletonList(2));
    matrix.add(singletonList(3));
    matrix.add(singletonList(4));
    assertEquals(asList(1, 2, 3, 4), zigzag(matrix));
  }

  @Test
  public void zigzag_withMultipleRows_sameSize() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    matrix.add(asList(5, 6, 7, 8));
    matrix.add(asList(9, 10, 11, 12));
    assertEquals(asList(1, 2, 3, 4, 8, 7, 6, 5, 9, 10, 11, 12), zigzag(matrix));
  }

  @Test
  public void zigzag_withMultipleRows_differentSize() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2));
    matrix.add(asList(3, 4, 5, 6, 7));
    matrix.add(asList(8, 9, 10));
    matrix.add(asList(11, 12, 13, 14));
    assertEquals(asList(1, 2, 7, 6, 5, 4, 3, 8, 9, 10, 14, 13, 12, 11), zigzag(matrix));
  }

  @Test
  public void zigzag_withMultipleRows_withNullOrEmptyRows() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(null);
    matrix.add(emptyList());
    matrix.add(singletonList(1));
    assertEquals(singletonList(1), zigzag(matrix));

    matrix.add(asList(2, 3));
    assertEquals(asList(1, 3, 2), zigzag(matrix));

    matrix.add(emptyList());
    matrix.add(asList(4, 5, 6));
    assertEquals(asList(1, 3, 2, 4, 5, 6), zigzag(matrix));

    matrix.add(null);
    matrix.add(null);
    matrix.add(emptyList());
    matrix.add(emptyList());
    matrix.add(null);
    matrix.add(asList(7, 8));
    assertEquals(asList(1, 3, 2, 4, 5, 6, 8, 7), zigzag(matrix));
  }

  @Test
  public void spiral_withNull() {
    assertEquals(emptyList(), spiral(null));
  }

  @Test
  public void spiral_withEmpty() {
    assertEquals(emptyList(), spiral(emptyList()));
  }

  @Test
  public void spiral_withOnlyOneRow() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    assertEquals(asList(1, 2, 3, 4), spiral(matrix));
  }

  @Test
  public void spiral_withOnlyOneColumn() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(singletonList(1));
    matrix.add(singletonList(2));
    matrix.add(singletonList(3));
    matrix.add(singletonList(4));
    assertEquals(asList(1, 2, 3, 4), spiral(matrix));
  }

  @Test
  public void spiral_withMultipleRows_rectangle_oneLoop() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4, 5));
    matrix.add(asList(6, 7, 8, 9, 10));
    matrix.add(asList(11, 12, 13, 14, 15));
    assertEquals(
        asList(1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9),
        spiral(matrix));
  }

  @Test
  public void spiral_withMultipleRows_rectangle_multipleLoops() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4, 5));
    matrix.add(asList(6, 7, 8, 9, 10));
    matrix.add(asList(11, 12, 13, 14, 15));
    matrix.add(asList(16, 17, 18, 19, 20));
    assertEquals(
        asList(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12),
        spiral(matrix));
  }

  @Test
  public void spiral_withMultipleRows_square_oneLoop() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2));
    matrix.add(asList(3, 4));
    assertEquals(asList(1, 2, 4, 3), spiral(matrix));
  }

  @Test
  public void spiral_withMultipleRows_square_multipleLoops() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    matrix.add(asList(5, 6, 7, 8));
    matrix.add(asList(9, 10, 11, 12));
    matrix.add(asList(13, 14, 15, 16));
    assertEquals(
        asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10),
        spiral(matrix));
  }

}