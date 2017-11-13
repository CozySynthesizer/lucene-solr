
package org.apache.lucene.search.highlight;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class TokenGroupBase implements java.io.Serializable {
  protected OffsetAttribute _var526;
  protected Float _var553;
  protected java.util.HashSet< _Type39  > _var521;
  public TokenGroupBase() {
    clear();
  }

  public void clear() {
    _var526 = null;
    _var553 = null;
    _var521 = new java.util.HashSet< _Type39  > ();
  }

  public Float  __getScore (int i) {
    Token _v41;
    _v41 = new Token(null, 0, 0);
    _label42: do {
      for (_Type39 _x44 : _var521) {
        if ((((_x44)._0 == i))) {
          _v41 = (_x44)._1;
          break _label42;
        }
      }
    } while (false);
    return (_v41).score;
  }

  public Float  __getTotalScore () {
    return _var553;
  }

  public int  getStartOffset () {
    int _min45;
    _min45 = 0;
    boolean _first46;
    _first46 = true;
    for (_Type39 _x48 : _var521) {
      if ((((_x48)._1).score > 0.0f)) {
        if ((_first46 || (((_x48)._1).startOffset < _min45))) {
          _first46 = false;
          _min45 = ((_x48)._1).startOffset;
        }
      }
    }
    return _min45;
  }

  public int  getEndOffset () {
    int _max49;
    _max49 = 0;
    boolean _first50;
    _first50 = true;
    for (_Type39 _x52 : _var521) {
      if ((((_x52)._1).score > 0.0f)) {
        if ((_first50 || (((_x52)._1).endOffset > _max49))) {
          _first50 = false;
          _max49 = ((_x52)._1).endOffset;
        }
      }
    }
    return _max49;
  }

  public boolean  isDistinct () {
    int _max53;
    _max53 = 0;
    boolean _first54;
    _first54 = true;
    for (_Type39 _x56 : _var521) {
      if ((_first54 || (((_x56)._1).endOffset > _max53))) {
        _first54 = false;
        _max53 = ((_x56)._1).endOffset;
      }
    }
    return ((_var526.startOffset()) >= _max53);
  }

  public int  getNumTokens () {
    int _sum57;
    _sum57 = 0;
    for (_Type39 _x59 : _var521) {
      _sum57 = (_sum57 + 1);
    }
    return _sum57;
  }

  public void __setOffsetAtt (OffsetAttribute o) {
    _var526 = o;
  }

  public void __clearTotal () {
    _var553 = (0.0f);
  }

  public void __addToken (Float score) {
    java.util.ArrayList<_Type39 > _v60;
    _v60 = new java.util.ArrayList<_Type39 > ();
    for (_Type39 _x72 : _var521) {
      _v60.add(_x72);
    }
    int _sum63;
    _sum63 = 0;
    for (_Type39 _x65 : _var521) {
      _sum63 = (_sum63 + 1);
    }
    if ((_sum63 < 50)) {
      for (_Type39 _x66 : _var521) {
        _v60.remove(_x66);
      }
      int _sum67;
      _sum67 = 0;
      for (_Type39 _x69 : _var521) {
        _sum67 = (_sum67 + 1);
      }
      _v60.remove(new _Type39(_sum67, new Token(score, (_var526.startOffset()), (_var526.endOffset()))));
    } else {
      for (_Type39 _x70 : _var521) {
        _v60.remove(_x70);
      }
    }
    for (_Type39 _x73 : _v60) {
      _var521.remove(_x73);
    }
    java.util.ArrayList<_Type39 > _v74;
    _v74 = new java.util.ArrayList<_Type39 > ();
    int _sum79;
    _sum79 = 0;
    for (_Type39 _x81 : _var521) {
      _sum79 = (_sum79 + 1);
    }
    if ((_sum79 < 50)) {
      for (_Type39 _x82 : _var521) {
        _v74.add(_x82);
      }
      int _sum83;
      _sum83 = 0;
      for (_Type39 _x85 : _var521) {
        _sum83 = (_sum83 + 1);
      }
      _v74.add(new _Type39(_sum83, new Token(score, (_var526.startOffset()), (_var526.endOffset()))));
    } else {
      for (_Type39 _x86 : _var521) {
        _v74.add(_x86);
      }
    }
    for (_Type39 _x76 : _var521) {
      _v74.remove(_x76);
    }
    for (_Type39 _x87 : _v74) {
      _var521.add(_x87);
    }
    Float _v88;
    int _sum89;
    _sum89 = 0;
    for (_Type39 _x91 : _var521) {
      _sum89 = (_sum89 + 1);
    }
    if ((_sum89 < 50)) {
      Float _v92;
int _sum93;
_sum93 = 0;
for (_Type39 _x95 : _var521) {
  _sum93 = (_sum93 + 1);
}
      if ((((0 == _sum93)) || (score > 0.0f))) {
        _v92 = (_var553 + score);
      } else {
        _v92 = _var553;
      }
      _v88 = _v92;
    } else {
      _v88 = _var553;
    }
    _var553 = _v88;
  }

  public static class Token implements java.io.Serializable {
    private Float score;
    private int startOffset;
    private int endOffset;
    public Float  getScore() { return score; }
    public int  getStartOffset() { return startOffset; }
    public int  getEndOffset() { return endOffset; }
    public Token(Float score, int startOffset, int endOffset) {
      this.score = score;
      this.startOffset = startOffset;
      this.endOffset = endOffset;
    }
    @Override
    public int hashCode() {
      int _hash_code96 = 0;
      _hash_code96 = (_hash_code96 * 31) ^ ((score).hashCode());
      _hash_code96 = (_hash_code96 * 31) ^ (startOffset);
      _hash_code96 = (_hash_code96 * 31) ^ (endOffset);
      return _hash_code96;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof Token)) return false;
      Token o = (Token)other;
      return ((java.util.Objects.equals(this.score, o.score)) && (((this.startOffset == o.startOffset)) && ((this.endOffset == o.endOffset))));
    }
  }
  public static class _Type39 implements java.io.Serializable {
    private int _0;
    private Token _1;
    public int  get_0() { return _0; }
    public Token  get_1() { return _1; }
    public _Type39(int _0, Token _1) {
      this._0 = _0;
      this._1 = _1;
    }
    @Override
    public int hashCode() {
      int _hash_code97 = 0;
      _hash_code97 = (_hash_code97 * 31) ^ (_0);
      _hash_code97 = (_hash_code97 * 31) ^ ((_1).hashCode());
      return _hash_code97;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof _Type39)) return false;
      _Type39 o = (_Type39)other;
      return (((this._0 == o._0)) && (java.util.Objects.equals(this._1, o._1)));
    }
  }
}

