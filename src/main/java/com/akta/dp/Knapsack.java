package com.akta.dp;

import static java.lang.Math.max;

import java.util.List;
import java.util.Objects;

public class Knapsack {

  public static class Item {

    private int weight;
    private int value;

    private Item(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }

    public int getWeight() {
      return weight;
    }

    public int getValue() {
      return value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Item item = (Item) o;
      return weight == item.weight && value == item.value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(weight, value);
    }

    public static Item of(int weight, int value) {
      return new Item(weight, value);
    }

  }

  public static int solver(List<Item> items, int capacity) {
    return solverHelper(items, 0, capacity);
  }

  private static int solverHelper(List<Item> items, int index, int remainingCapacity) {
    if (index >= items.size() || remainingCapacity == 0) {
      return 0;
    } else if (remainingCapacity < items.get(index).getWeight()) {
      return solverHelper(items, index + 1, remainingCapacity);
    } else {
      int tmp1 = solverHelper(items, index + 1, remainingCapacity);
      Item currentItem = items.get(index);
      int tmp2 = currentItem.getValue() + solverHelper(items, index + 1,
          remainingCapacity - currentItem.getWeight());
      return max(tmp1, tmp2);
    }
  }

  public static int solverWithMemoize(List<Item> items, int capacity) {
    return solverWithMemoizeHelper(items, 0, capacity, new Integer[items.size() + 1][capacity + 1]);
  }

  private static int solverWithMemoizeHelper(
      List<Item> items,
      int index,
      int remainingCapacity,
      Integer[][] memoized) {
    if (memoized[index][remainingCapacity] != null) {
      return memoized[index][remainingCapacity];
    }
    int result;
    if (index >= items.size() || remainingCapacity == 0) {
      result = 0;
    } else if (remainingCapacity < items.get(index).getWeight()) {
      result = solverWithMemoizeHelper(items, index + 1, remainingCapacity, memoized);
    } else {
      int tmp1 = solverWithMemoizeHelper(items, index + 1, remainingCapacity, memoized);
      Item currentItem = items.get(index);
      int tmp2 = currentItem.getValue() + solverWithMemoizeHelper(items, index + 1,
          remainingCapacity - currentItem.getWeight(), memoized);
      result = max(tmp1, tmp2);
    }
    memoized[index][remainingCapacity] = result;
    return result;
  }

}
