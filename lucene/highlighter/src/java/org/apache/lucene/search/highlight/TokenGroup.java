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
  private OffsetAttribute offsetAttribute;

  public TokenGroup(TokenStream tokenStream) {
    this.offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
  }

  public void addToken(float score) {
    super.__addToken(score,
     this.offsetAttribute.startOffset(), this.offsetAttribute.endOffset());
  }

  public boolean isDistinct() {
    return super.__isDistinct(this.offsetAttribute.startOffset());
  }
}
