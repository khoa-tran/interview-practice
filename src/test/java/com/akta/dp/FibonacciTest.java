package com.akta.dp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

public class FibonacciTest {

  @Test
  public void simple() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Fibonacci.simple(0))
        .withMessage("input must be positive integer");
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Fibonacci.simple(-6))
        .withMessage("input must be positive integer");
    assertThat(Fibonacci.simple(1)).isEqualTo(1);
    assertThat(Fibonacci.simple(2)).isEqualTo(1);
    assertThat(Fibonacci.simple(3)).isEqualTo(2);
    assertThat(Fibonacci.simple(4)).isEqualTo(3);
    assertThat(Fibonacci.simple(5)).isEqualTo(5);
    assertThat(Fibonacci.simple(12)).isEqualTo(144);
    assertThat(Fibonacci.simple(25)).isEqualTo(75025);
  }

  @Test
  public void memoized() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Fibonacci.memoized(0))
        .withMessage("input must be positive integer");
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Fibonacci.memoized(-6))
        .withMessage("input must be positive integer");
    assertThat(Fibonacci.memoized(1)).isEqualTo(1);
    assertThat(Fibonacci.memoized(2)).isEqualTo(1);
    assertThat(Fibonacci.memoized(3)).isEqualTo(2);
    assertThat(Fibonacci.memoized(4)).isEqualTo(3);
    assertThat(Fibonacci.memoized(5)).isEqualTo(5);
    assertThat(Fibonacci.memoized(12)).isEqualTo(144);
    assertThat(Fibonacci.memoized(25)).isEqualTo(75025);
  }

  @Test
  public void iterativelyMemoized() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Fibonacci.iterativelyMemoized(0))
        .withMessage("input must be positive integer");
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Fibonacci.iterativelyMemoized(-6))
        .withMessage("input must be positive integer");
    assertThat(Fibonacci.iterativelyMemoized(1)).isEqualTo(1);
    assertThat(Fibonacci.iterativelyMemoized(2)).isEqualTo(1);
    assertThat(Fibonacci.iterativelyMemoized(3)).isEqualTo(2);
    assertThat(Fibonacci.iterativelyMemoized(4)).isEqualTo(3);
    assertThat(Fibonacci.iterativelyMemoized(5)).isEqualTo(5);
    assertThat(Fibonacci.iterativelyMemoized(12)).isEqualTo(144);
    assertThat(Fibonacci.iterativelyMemoized(25)).isEqualTo(75025);
  }

}