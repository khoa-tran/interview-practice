package com.akta.dp;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

import com.akta.dp.Knapsack.Item;
import java.util.List;
import org.junit.Test;

public class KnapsackTest {

  @Test
  public void solver_capacityLessThanWeightOfItems_returnsZero() {
    List<Item> items = asList(
        Item.of(4, 5),
        Item.of(3, 7));
    int capacity = 2;
    assertThat(Knapsack.solver(items, capacity)).isEqualTo(0);
  }

  @Test
  public void solver_emptyItems_returnsZero() {
    List<Item> items = emptyList();
    int capacity = 2;
    assertThat(Knapsack.solver(items, capacity)).isEqualTo(0);
  }

  @Test
  public void solver_largeEnoughCapacity_returnsSumValues() {
    List<Item> items = asList(
        Item.of(4, 5),
        Item.of(3, 7));
    int capacity = 10;
    assertThat(Knapsack.solver(items, capacity)).isEqualTo(12);
  }

  @Test
  public void solver_smallCapacity_returnsMaxValue() {
    List<Item> items = asList(
        Item.of(4, 5),
        Item.of(3, 7));
    int capacity = 5;
    assertThat(Knapsack.solver(items, capacity)).isEqualTo(7);
  }

  @Test
  public void solver() {
    List<Item> items = asList(
        Item.of(1, 5),
        Item.of(2, 3),
        Item.of(4, 5),
        Item.of(2, 3),
        Item.of(5, 2));
    int capacity = 10;
    assertThat(Knapsack.solver(items, capacity)).isEqualTo(16);
  }

}