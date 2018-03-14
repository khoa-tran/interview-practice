package com.akta.list;

import static com.akta.list.MatrixTraverse.spiral;
import static com.akta.list.MatrixTraverse.zigzag;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MatrixTraverseTest {

  @Test
  public void zigzag_withNull() {
    assertThat(zigzag(null)).isEmpty();
  }

  @Test
  public void zigzag_withEmpty() {
    assertThat(zigzag(emptyList())).isEmpty();
  }

  @Test
  public void zigzag_withOnlyOneRow() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    assertThat(zigzag(matrix)).containsExactly(1, 2, 3, 4);
  }

  @Test
  public void zigzag_withOnlyOneColumn() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(singletonList(1));
    matrix.add(singletonList(2));
    matrix.add(singletonList(3));
    matrix.add(singletonList(4));
    assertThat(zigzag(matrix)).containsExactly(1, 2, 3, 4);
  }

  @Test
  public void zigzag_withMultipleRows_sameSize() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    matrix.add(asList(5, 6, 7, 8));
    matrix.add(asList(9, 10, 11, 12));
    assertThat(zigzag(matrix)).containsExactly(1, 2, 3, 4, 8, 7, 6, 5, 9, 10, 11, 12);
  }

  @Test
  public void zigzag_withMultipleRows_differentSize() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2));
    matrix.add(asList(3, 4, 5, 6, 7));
    matrix.add(asList(8, 9, 10));
    matrix.add(asList(11, 12, 13, 14));
    assertThat(zigzag(matrix)).containsExactly(1, 2, 7, 6, 5, 4, 3, 8, 9, 10, 14, 13, 12, 11);
  }

  @Test
  public void zigzag_withMultipleRows_withNullOrEmptyRows() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(null);
    matrix.add(emptyList());
    matrix.add(singletonList(1));
    assertThat(zigzag(matrix)).containsExactly(1);

    matrix.add(asList(2, 3));
    assertThat(zigzag(matrix)).containsExactly(1, 3, 2);

    matrix.add(emptyList());
    matrix.add(asList(4, 5, 6));
    assertThat(zigzag(matrix)).containsExactly(1, 3, 2, 4, 5, 6);

    matrix.add(null);
    matrix.add(null);
    matrix.add(emptyList());
    matrix.add(emptyList());
    matrix.add(null);
    matrix.add(asList(7, 8));
    assertThat(zigzag(matrix)).containsExactly(1, 3, 2, 4, 5, 6, 8, 7);
  }

  @Test
  public void spiral_withNull() {
    assertThat(spiral(null)).isEmpty();
  }

  @Test
  public void spiral_withEmpty() {
    assertThat(spiral(null)).isEmpty();
  }

  @Test
  public void spiral_withOnlyOneRow() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    assertThat(spiral(matrix)).containsExactly(1, 2, 3, 4);
  }

  @Test
  public void spiral_withOnlyOneColumn() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(singletonList(1));
    matrix.add(singletonList(2));
    matrix.add(singletonList(3));
    matrix.add(singletonList(4));
    assertThat(spiral(matrix)).containsExactly(1, 2, 3, 4);
  }

  @Test
  public void spiral_withMultipleRows_rectangle_oneLoop() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4, 5));
    matrix.add(asList(6, 7, 8, 9, 10));
    matrix.add(asList(11, 12, 13, 14, 15));
    assertThat(spiral(matrix)).containsExactly(1, 2, 3, 4, 5, 10, 15, 14, 13, 12, 11, 6, 7, 8, 9);
  }

  @Test
  public void spiral_withMultipleRows_rectangle_multipleLoops() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4, 5));
    matrix.add(asList(6, 7, 8, 9, 10));
    matrix.add(asList(11, 12, 13, 14, 15));
    matrix.add(asList(16, 17, 18, 19, 20));
    assertThat(spiral(matrix))
        .containsExactly(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12);
  }

  @Test
  public void spiral_withMultipleRows_square_oneLoop() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2));
    matrix.add(asList(3, 4));
    assertThat(spiral(matrix)).containsExactly(1, 2, 4, 3);
  }

  @Test
  public void spiral_withMultipleRows_square_multipleLoops() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(asList(1, 2, 3, 4));
    matrix.add(asList(5, 6, 7, 8));
    matrix.add(asList(9, 10, 11, 12));
    matrix.add(asList(13, 14, 15, 16));
    assertThat(spiral(matrix))
        .containsExactly(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
  }

}