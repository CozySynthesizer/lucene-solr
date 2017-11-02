
package org.apache.lucene.search.highlight;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class TokenGroupBase implements java.io.Serializable {
  protected OffsetAttribute _var508;
  protected Float _var511;
  protected java.util.HashSet< _Type39  > _var479;
  public TokenGroupBase() {
    clear();
  }

  public void clear() {
    _var508 = null;
    _var511 = null;
    _var479 = new java.util.HashSet< _Type39  > ();
  }

  public Float  __getScore (int i) {
    Token _v41;
    _v41 = new Token(null, 0, 0);
    _label42: do {
      for (_Type39 _x44 : _var479) {
        if ((((_x44)._0 == i))) {
          _v41 = (_x44)._1;
          break _label42;
        }
      }
    } while (false);
    return (_v41).score;
  }

  public int  getStartOffset () {
    int _min45;
    _min45 = 0;
    boolean _first46;
    _first46 = true;
    for (_Type39 _x48 : _var479) {
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
    for (_Type39 _x52 : _var479) {
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
    for (_Type39 _x56 : _var479) {
      if ((((_x56)._1).score > 0.0f)) {
        if ((_first54 || (((_x56)._1).endOffset > _max53))) {
          _first54 = false;
          _max53 = ((_x56)._1).endOffset;
        }
      }
    }
    return ((_var508.startOffset()) >= _max53);
  }

  public int  getNumTokens () {
    int _sum57;
    _sum57 = 0;
    for (_Type39 _x59 : _var479) {
      _sum57 = (_sum57 + 1);
    }
    return _sum57;
  }

  public Float  __getTotalScore () {
    return _var511;
  }

  public void setOffsetAtt (OffsetAttribute o) {
    _var508 = o;
  }

  public void clearTotal () {
    _var511 = (0.0f);
  }

  public void __addToken (Float score) {
    java.util.ArrayList<_Type39 > _v60;
    _v60 = new java.util.ArrayList<_Type39 > ();
    for (_Type39 _x67 : _var479) {
      _v60.add(_x67);
    }
    for (_Type39 _x62 : _var479) {
      _v60.remove(_x62);
    }
    int _sum63;
    _sum63 = 0;
    for (_Type39 _x65 : _var479) {
      _sum63 = (_sum63 + 1);
    }
    _v60.remove(new _Type39(_sum63, new Token(score, 0, 0)));
    for (_Type39 _x68 : _v60) {
      _var479.remove(_x68);
    }
    java.util.ArrayList<_Type39 > _v69;
    _v69 = new java.util.ArrayList<_Type39 > ();
    for (_Type39 _x73 : _var479) {
      _v69.add(_x73);
    }
    int _sum74;
    _sum74 = 0;
    for (_Type39 _x76 : _var479) {
      _sum74 = (_sum74 + 1);
    }
    _v69.add(new _Type39(_sum74, new Token(score, 0, 0)));
    for (_Type39 _x71 : _var479) {
      _v69.remove(_x71);
    }
    for (_Type39 _x77 : _v69) {
      _var479.add(_x77);
    }
    _var511 = (_var511 + score);
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
      int _hash_code78 = 0;
      _hash_code78 = (_hash_code78 * 31) ^ ((score).hashCode());
      _hash_code78 = (_hash_code78 * 31) ^ (startOffset);
      _hash_code78 = (_hash_code78 * 31) ^ (endOffset);
      return _hash_code78;
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
      int _hash_code79 = 0;
      _hash_code79 = (_hash_code79 * 31) ^ (_0);
      _hash_code79 = (_hash_code79 * 31) ^ ((_1).hashCode());
      return _hash_code79;
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

