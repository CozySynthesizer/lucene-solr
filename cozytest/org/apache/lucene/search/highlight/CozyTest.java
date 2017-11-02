package org.apache.lucene.search.highlight;

import java.io.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.core.*;
import org.apache.lucene.analysis.tokenattributes.*;
import org.apache.lucene.analysis.en.EnglishAnalyzer;

public class CozyTest {
  public static void main(String[] args) {
    CozyTest.TestConstructor();
    CozyTest.TestAddToken();
    CozyTest.TestIsDistinct();
    CozyTest.TestGetScore();
    CozyTest.TestGetStartOffset();
    CozyTest.TestGetEndOffset();
    CozyTest.TestGetNumTokens();
    CozyTest.TestGetTotalScore();
  }

  private static TokenGroup createBasicTokenGroup() {
    Reader reader = new StringReader("a b c d eee david zzz");
    Analyzer analyzer = new EnglishAnalyzer();
    TokenStream stream = analyzer.tokenStream(null, reader);
    return new TokenGroup(stream);
  }

  private static void heading(String s) {
    System.out.println("** " + s);
  }

  private static void report(String s) {
    System.out.println("  " + s);
  }

  private static void TestConstructor() {
    heading("Constructor");

    try {
      new TokenGroup(null);
      report(".ctor(null) succeeded");
    } catch (Exception e) {
      report(String.format(".ctor(null) failed w/ exeception %s.",
            e.getClass().getSimpleName()));
    }
  }

  private static void TestAddToken() {
    heading("addToken");

    Reader reader = new StringReader("a b c d eee david zzz");
    Analyzer analyzer = new EnglishAnalyzer();
    TokenStream stream = analyzer.tokenStream(null, reader);
    TokenGroup group = new TokenGroup(stream);

    group.addToken(2.3f);
    group.addToken(33.5f);

    report(Integer.toString(group.getNumTokens()));
    report(Float.toString(group.getTotalScore()));
  }

  private static void TestIsDistinct() {
    heading("isDistinct");

    TokenGroup g = createBasicTokenGroup();

    report(String.format("distinct w/ no tokens: %s", g.isDistinct()));

    g.addToken(0.2455f);
    report(String.format("distinct w/ 1 token: %s", g.isDistinct()));

    g.addToken(0.449f);
    report(String.format("distinct w/ 2 token: %s", g.isDistinct()));
  }

  private static void TestGetScore() {
    heading("getScore");

    TokenGroup g = createBasicTokenGroup();

    g.addToken(0.22f);
    report(String.format("getScore(0): %s", g.getScore(0)));

    g.addToken(0.26f);
    report(String.format("getScore(0): %s", g.getScore(0)));
    report(String.format("getScore(1): %s", g.getScore(1)));

    g.addToken(0.29f);
    report(String.format("getScore(0): %s", g.getScore(0)));
    report(String.format("getScore(1): %s", g.getScore(1)));
    report(String.format("getScore(2): %s", g.getScore(2)));
  }

  private static void TestGetStartOffset() {
    heading("getStartOffset");

    TokenGroup g = createBasicTokenGroup();

    report(String.format("initial: %d", g.getStartOffset()));

    g.addToken(0.22f);
    report(String.format(".22 %d", g.getStartOffset()));
  }

  private static void TestGetEndOffset() {
    heading("getEndOffset");

    TokenGroup g = createBasicTokenGroup();

    report(String.format("initial: %d", g.getEndOffset()));

    g.addToken(0.22f);
    report(String.format(".22 %d", g.getEndOffset()));
  }

  private static void TestGetNumTokens() {
    heading("getNumTokens");
    TokenGroup g = createBasicTokenGroup();
    report(String.format("initial: %d", g.getNumTokens()));

    g.addToken(0.22f);
    report(String.format(".22 %d", g.getNumTokens()));
  }

  private static void TestGetTotalScore() {
    heading("getTotalScore");
    TokenGroup g = createBasicTokenGroup();
    report(String.format("initial: %f", g.getTotalScore()));

    g.addToken(0.22f);
    report(String.format(".22 %f", g.getTotalScore()));

    g.addToken(-0.22f);
    report(String.format("-.22 %f", g.getTotalScore()));
    g.addToken(0.83f);
    report(String.format("+.83 %f", g.getTotalScore()));
  }
}
