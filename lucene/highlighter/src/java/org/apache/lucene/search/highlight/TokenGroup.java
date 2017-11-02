package org.apache.lucene.search.highlight;

import java.util.*;
import java.lang.*;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

/**
 * One, or several overlapping tokens, along with the score(s) and the scope of
 * the original text.
 * <p>(This is the glue required to maintain the original TokenGroup interface.
 * The Cozy-synthesized implementation is TokenGroupBase.)</p>
 */
public class TokenGroup extends TokenGroupBase {
  public TokenGroup(TokenStream tokenStream) {
    this.setOffsetAtt(tokenStream.addAttribute(OffsetAttribute.class));
    this.clearTotal();
  }

  // Cozy's implementation uses the boxed Floats, but we must present an
  // interface using unboxed native floats.
  public void addToken(float score) {
    super.__addToken((Float)score);
  }

  public float getTotalScore() {
    return (float) super.__getTotalScore();
  }

  public float getScore(int i) {
    return (float) super.__getScore(i);
  }
}
