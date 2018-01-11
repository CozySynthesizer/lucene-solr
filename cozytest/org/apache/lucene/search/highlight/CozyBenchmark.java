package org.apache.lucene.search.highlight;

public class CozyBenchmark {
  private static final int WARMUP     = 10000;
  private static final int ITERATIONS = 90000;

  public static void main(String[] args) {
    for (int i = 0; i < WARMUP; i++) {
      new CozyTest(true).run();
    }

    final long startTime = System.currentTimeMillis();

    for (int i = 0; i < ITERATIONS; i++) {
      new CozyTest(true).run();
    }

    final long endTime = System.currentTimeMillis();

    System.out.println("bench time: " + (((float)(endTime - startTime))/1000.0f));
  }
}
