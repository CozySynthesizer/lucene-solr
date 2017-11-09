package org.apache.lucene.search.highlight;

import java.io.*;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.core.*;
import org.apache.lucene.analysis.tokenattributes.*;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

/**
 * This class exercises a TokenGroup's effective behavior. One can run this
 * against two TokenGroup implementations to determine how similar they are.
 */
public class CozyTest {
  public static void main(String[] args) {
    new CozyTest().run();
  }

  private boolean quiet = false;

  public CozyTest() {
  }

  public CozyTest(boolean quiet) {
    this.quiet = quiet;
  }

  public void run() {
    this.TestConstructor();
    this.TestAddToken();
    this.TestIsDistinct();
    this.TestGetScore();
    this.TestGetStartOffset();
    this.TestGetEndOffset();
    this.TestGetNumTokens();
    this.TestGetTotalScore();
    this.TestMaxTokens();

    this.TestTokenStreamAdvancement();
  }

  private TokenGroup createBasicTokenGroup() {
    Reader reader = new StringReader("a b c d eee david zzz un weufnnoiwjd qien ianef aine a "
        + "apple cow roger foo foor food foog foot fooy fooi opal "
        + "quick quack quux sift");
    Analyzer analyzer = new StandardAnalyzer();
    //Reader reader = new StringReader("a b c d eee david zzz");
    //Analyzer analyzer = new EnglishAnalyzer();
    TokenStream stream = analyzer.tokenStream(null, reader);
    return new TokenGroup(stream);
  }

  private void heading(String s) {
    if (!this.quiet) {
      System.out.println("** " + s);
    }
  }

  private void report(String s) {
    if (!this.quiet) {
      System.out.println("  " + s);
    }
  }

  private void TestConstructor() {
    heading("Constructor");

    try {
      new TokenGroup(null);
      report(".ctor(null) succeeded");
    } catch (Exception e) {
      report(String.format(".ctor(null) failed w/ exeception %s.",
            e.getClass().getSimpleName()));
    }
  }

  private void TestAddToken() {
    heading("addToken");

    Reader reader = new StringReader("a b c d eee david zzz");
    Analyzer analyzer = new EnglishAnalyzer();
    TokenStream stream = analyzer.tokenStream(null, reader);
    TokenGroup group = new TokenGroup(stream);

    group.addToken(2.3f);

    report(Integer.toString(group.getNumTokens()));
    report(Float.toString(group.getTotalScore()));

    group.addToken(33.5f);

    report(Integer.toString(group.getNumTokens()));
    report(Float.toString(group.getTotalScore()));
  }

  private void TestIsDistinct() {
    heading("isDistinct");

    TokenGroup g = createBasicTokenGroup();

    report(String.format("distinct w/ no tokens: %s", g.isDistinct()));

    g.addToken(0.2455f);
    report(String.format("distinct w/ 1 token: %s", g.isDistinct()));

    g.addToken(0.449f);
    report(String.format("distinct w/ 2 token: %s", g.isDistinct()));
  }

  private void TestGetScore() {
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

  private void TestGetStartOffset() {
    heading("getStartOffset");

    TokenGroup g = createBasicTokenGroup();

    report(String.format("initial: %d", g.getStartOffset()));

    g.addToken(0.22f);
    report(String.format(".22 %d", g.getStartOffset()));
  }

  private void TestGetEndOffset() {
    heading("getEndOffset");

    TokenGroup g = createBasicTokenGroup();

    report(String.format("initial: %d", g.getEndOffset()));

    g.addToken(0.22f);
    report(String.format(".22 %d", g.getEndOffset()));
  }

  private void TestGetNumTokens() {
    heading("getNumTokens");
    TokenGroup g = createBasicTokenGroup();
    report(String.format("initial: %d", g.getNumTokens()));

    g.addToken(0.22f);
    report(String.format(".22 %d", g.getNumTokens()));
  }

  private void TestGetTotalScore() {
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

  private void TestMaxTokens() {
    heading("getMaxTokens");
    TokenGroup g = createBasicTokenGroup();
    // Original TokenGroup limits the tokens to 50.
    // Add 50 tokens and see what happens when more are added.

    for (int i = 0; i < 48; i++) {
      g.addToken((float) i);
    }

    g.addToken(48.0f);
    report(String.format("%f", g.getTotalScore()));
    g.addToken(49.0f);
    report(String.format("%f", g.getTotalScore()));
    g.addToken(50.0f);
    report(String.format("%f", g.getTotalScore()));
  }

  private void TestTokenStreamAdvancement() {
    // Do some things that may be dependent on advancing the TokenStream.

    heading("tokenStreamAdvancement");
    Reader reader = new StringReader("a b c d eee david zzz un weufnnoiwjd qien ianef aine a "
     + "apple cow roger foo foor food foog foot fooy fooi opal "
     + "quick quack quux sift");
    Analyzer analyzer = new StandardAnalyzer();
    TokenStream stream = analyzer.tokenStream(null, reader);
    TokenGroup g = new TokenGroup(stream);

    try {
      stream.reset();
    } catch (IOException ex) {
      report("(Threw IOException.)");
    }

    report(String.valueOf(g.isDistinct()));

    g.addToken(1.0f);
    report(String.format("%f", g.getTotalScore()));
    g.addToken(2.0f);
    report(String.format("%f", g.getTotalScore()));
    g.addToken(3.0f);
    report(String.format("%f", g.getTotalScore()));

    try {
      stream.incrementToken();
    } catch (IOException ex) {
      report("(Threw IOException.)");
    }
    report(String.valueOf(g.isDistinct()));

    g.addToken(48.0f);
    report(String.format("%f", g.getTotalScore()));
    g.addToken(49.0f);
    report(String.format("%f", g.getTotalScore()));
    g.addToken(50.0f);
    report(String.format("%f", g.getTotalScore()));

    report(String.valueOf(g.isDistinct()));
  }
}
