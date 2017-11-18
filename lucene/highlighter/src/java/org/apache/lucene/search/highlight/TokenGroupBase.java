
package org.apache.lucene.search.highlight;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class TokenGroupBase implements java.io.Serializable {
  protected OffsetAttribute _var525;
  protected Float _var552;
  protected java.util.HashSet< _Type39  > _var520;
  public TokenGroupBase() {
    clear();
  }

  public void clear() {
    _var525 = null;
    _var552 = null;
    _var520 = new java.util.HashSet< _Type39  > ();
  }

  public Float  __getScore (int i) {
    Token _v41;
    Token _var44;
    _var44 = new Token(null, 0, 0);
    _v41 = _var44;
    _label42: do {
      for (_Type39 _x45 : _var520) {
        if ((((_x45)._0 == i))) {
          Token _var46;
          _var46 = (_x45)._1;
          _v41 = _var46;
          break _label42;
        }
      }
    } while (false);
    return (_v41).score;
  }

  public Float  __getTotalScore () {
    return _var552;
  }

  public int  getStartOffset () {
    int _min47;
    int _var50;
    _var50 = 0;
    _min47 = _var50;
    boolean _first48;
    boolean _var51;
    _var51 = true;
    _first48 = _var51;
    for (_Type39 _x52 : _var520) {
      if ((((_x52)._1).score > 0.0f)) {
        if ((_first48 || (((_x52)._1).startOffset < _min47))) {
          boolean _var53;
          _var53 = false;
          _first48 = _var53;
          int _var54;
          _var54 = ((_x52)._1).startOffset;
          _min47 = _var54;
        }
      }
    }
    return _min47;
  }

  public int  getEndOffset () {
    int _max55;
    int _var58;
    _var58 = 0;
    _max55 = _var58;
    boolean _first56;
    boolean _var59;
    _var59 = true;
    _first56 = _var59;
    for (_Type39 _x60 : _var520) {
      if ((((_x60)._1).score > 0.0f)) {
        if ((_first56 || (((_x60)._1).endOffset > _max55))) {
          boolean _var61;
          _var61 = false;
          _first56 = _var61;
          int _var62;
          _var62 = ((_x60)._1).endOffset;
          _max55 = _var62;
        }
      }
    }
    return _max55;
  }

  public boolean  isDistinct () {
    int _max63;
    int _var66;
    _var66 = 0;
    _max63 = _var66;
    boolean _first64;
    boolean _var67;
    _var67 = true;
    _first64 = _var67;
    for (_Type39 _x68 : _var520) {
      if ((_first64 || (((_x68)._1).endOffset > _max63))) {
        boolean _var69;
        _var69 = false;
        _first64 = _var69;
        int _var70;
        _var70 = ((_x68)._1).endOffset;
        _max63 = _var70;
      }
    }
    return ((_var525.startOffset()) >= _max63);
  }

  public int  getNumTokens () {
    int _sum71;
    int _var73;
    _var73 = 0;
    _sum71 = _var73;
    for (_Type39 _x74 : _var520) {
      int _var75;
      _var75 = (_sum71 + 1);
      _sum71 = _var75;
    }
    return _sum71;
  }

  public void __setOffsetAtt (OffsetAttribute o) {
    OffsetAttribute _var76;
    _var76 = o;
    _var525 = _var76;
  }

  public void __clearTotal () {
    Float _var77;
    _var77 = (0.0f);
    _var552 = _var77;
  }

  public void __addToken (Float score) {
    java.util.ArrayList<_Type39 > _v78;
    _v78 = new java.util.ArrayList<_Type39 > ();
    for (_Type39 _x94 : _var520) {
      _v78.add(_x94);
    }
    int _sum81;
    int _var83;
    _var83 = 0;
    _sum81 = _var83;
    for (_Type39 _x84 : _var520) {
      int _var85;
      _var85 = (_sum81 + 1);
      _sum81 = _var85;
    }
    if ((_sum81 < 50)) {
      for (_Type39 _x86 : _var520) {
        _v78.remove(_x86);
      }
      int _sum87;
      int _var89;
      _var89 = 0;
      _sum87 = _var89;
      for (_Type39 _x90 : _var520) {
        int _var91;
        _var91 = (_sum87 + 1);
        _sum87 = _var91;
      }
      _v78.remove(new _Type39(_sum87, new Token(score, (_var525.startOffset()), (_var525.endOffset()))));
    } else {
      for (_Type39 _x92 : _var520) {
        _v78.remove(_x92);
      }
    }
    for (_Type39 _x95 : _v78) {
      _var520.remove(_x95);
    }
    java.util.ArrayList<_Type39 > _v96;
    _v96 = new java.util.ArrayList<_Type39 > ();
    int _sum101;
    int _var103;
    _var103 = 0;
    _sum101 = _var103;
    for (_Type39 _x104 : _var520) {
      int _var105;
      _var105 = (_sum101 + 1);
      _sum101 = _var105;
    }
    if ((_sum101 < 50)) {
      for (_Type39 _x106 : _var520) {
        _v96.add(_x106);
      }
      int _sum107;
      int _var109;
      _var109 = 0;
      _sum107 = _var109;
      for (_Type39 _x110 : _var520) {
        int _var111;
        _var111 = (_sum107 + 1);
        _sum107 = _var111;
      }
      _v96.add(new _Type39(_sum107, new Token(score, (_var525.startOffset()), (_var525.endOffset()))));
    } else {
      for (_Type39 _x112 : _var520) {
        _v96.add(_x112);
      }
    }
    for (_Type39 _x98 : _var520) {
      _v96.remove(_x98);
    }
    for (_Type39 _x113 : _v96) {
      _var520.add(_x113);
    }
    Float _var114;
    Float _v115;
    int _sum116;
    int _var118;
    _var118 = 0;
    _sum116 = _var118;
    for (_Type39 _x119 : _var520) {
      int _var120;
      _var120 = (_sum116 + 1);
      _sum116 = _var120;
    }
    if ((_sum116 < 50)) {
      Float _var121;
      Float _v122;
      boolean _v123;
      boolean _var126;
      _var126 = true;
      _v123 = _var126;
      _label124: do {
        for (_Type39 _x127 : _var520) {
          boolean _var128;
          _var128 = false;
          _v123 = _var128;
          break _label124;
        }
      } while (false);
      if ((_v123 || (score > 0.0f))) {
        Float _var129;
        _var129 = (_var552 + score);
        _v122 = _var129;
      } else {
        Float _var130;
        _var130 = _var552;
        _v122 = _var130;
      }
      _var121 = _v122;
      _v115 = _var121;
    } else {
      Float _var131;
      _var131 = _var552;
      _v115 = _var131;
    }
    _var114 = _v115;
    _var552 = _var114;
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
      int _hash_code132 = 0;
      _hash_code132 = (_hash_code132 * 31) ^ ((score).hashCode());
      _hash_code132 = (_hash_code132 * 31) ^ (startOffset);
      _hash_code132 = (_hash_code132 * 31) ^ (endOffset);
      return _hash_code132;
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
      int _hash_code133 = 0;
      _hash_code133 = (_hash_code133 * 31) ^ (_0);
      _hash_code133 = (_hash_code133 * 31) ^ ((_1).hashCode());
      return _hash_code133;
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

