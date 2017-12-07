
package org.apache.lucene.search.highlight;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class TokenGroupBase implements java.io.Serializable {
  protected java.util.ArrayList<_Type17 > _var383;
  protected Float _var461;
  public TokenGroupBase() {
    clear();
  }

  public void clear() {
    _var383 = new java.util.ArrayList<_Type17 > ();
    _var461 = null;
  }

  public Float  __getScore (int i) {
    Token _v19;
    Token _var22;
    _var22 = new Token(null, 0, 0);
    _v19 = _var22;
    _label20: do {
      for (_Type17 _x23 : _var383) {
        if ((((_x23)._0 == i))) {
          Token _var24;
          _var24 = (_x23)._1;
          _v19 = _var24;
          break _label20;
        }
      }
    } while (false);
    return (_v19).score;
  }

  public Float  __getTotalScore () {
    return _var461;
  }

  public int  getStartOffset () {
    int _min25;
    int _var28;
    _var28 = 0;
    _min25 = _var28;
    boolean _first26;
    boolean _var29;
    _var29 = true;
    _first26 = _var29;
    for (_Type17 _x30 : _var383) {
      if ((((_x30)._1).score > 0.0f)) {
        if ((_first26 || (((_x30)._1).startOffset < _min25))) {
          boolean _var31;
          _var31 = false;
          _first26 = _var31;
          int _var32;
          _var32 = ((_x30)._1).startOffset;
          _min25 = _var32;
        }
      }
    }
    return _min25;
  }

  public int  getEndOffset () {
    int _max33;
    int _var36;
    _var36 = 0;
    _max33 = _var36;
    boolean _first34;
    boolean _var37;
    _var37 = true;
    _first34 = _var37;
    for (_Type17 _x38 : _var383) {
      if ((((_x38)._1).score > 0.0f)) {
        if ((_first34 || (((_x38)._1).endOffset > _max33))) {
          boolean _var39;
          _var39 = false;
          _first34 = _var39;
          int _var40;
          _var40 = ((_x38)._1).endOffset;
          _max33 = _var40;
        }
      }
    }
    return _max33;
  }

  public boolean  __isDistinct (int startOffset) {
    int _max41;
    int _var44;
    _var44 = 0;
    _max41 = _var44;
    boolean _first42;
    boolean _var45;
    _var45 = true;
    _first42 = _var45;
    for (_Type17 _x46 : _var383) {
      if ((_first42 || (((_x46)._1).endOffset > _max41))) {
        boolean _var47;
        _var47 = false;
        _first42 = _var47;
        int _var48;
        _var48 = ((_x46)._1).endOffset;
        _max41 = _var48;
      }
    }
    return (startOffset >= _max41);
  }

  public int  getNumTokens () {
    int _sum49;
    int _var51;
    _var51 = 0;
    _sum49 = _var51;
    for (_Type17 _x52 : _var383) {
      int _var53;
      _var53 = (_sum49 + 1);
      _sum49 = _var53;
    }
    return _sum49;
  }

  public void __clearTotal () {
    Float _var54;
    _var54 = (0.0f);
    _var461 = _var54;
  }

  public void __addToken (Float score, int startOffset, int endOffset) {
    java.util.ArrayList<_Type17 > _name13;
    java.util.ArrayList<_Type17 > _var55;
    _var55 = new java.util.ArrayList<_Type17 > ();
    int _sum58;
    int _var60;
    _var60 = 0;
    _sum58 = _var60;
    for (_Type17 _x61 : _var383) {
      int _var62;
      _var62 = (_sum58 + 1);
      _sum58 = _var62;
    }
    if ((_sum58 < 50)) {
      java.util.ArrayList<_Type17 > _v63;
      _v63 = new java.util.ArrayList<_Type17 > ();
      for (_Type17 _x72 : _var383) {
        _v63.add(_x72);
      }
      for (_Type17 _x65 : _var383) {
        _v63.remove(_x65);
      }
      int _sum66;
      int _var68;
      _var68 = 0;
      _sum66 = _var68;
      for (_Type17 _x69 : _var383) {
        int _var70;
        _var70 = (_sum66 + 1);
        _sum66 = _var70;
      }
      _v63.remove(new _Type17(_sum66, new Token(score, startOffset, endOffset)));
      for (_Type17 _x73 : _v63) {
        _var55.add(_x73);
      }
    } else {
      java.util.ArrayList<_Type17 > _v74;
      _v74 = new java.util.ArrayList<_Type17 > ();
      for (_Type17 _x78 : _var383) {
        _v74.add(_x78);
      }
      for (_Type17 _x76 : _var383) {
        _v74.remove(_x76);
      }
      for (_Type17 _x79 : _v74) {
        _var55.add(_x79);
      }
    }
    _name13 = _var55;
    java.util.ArrayList<_Type17 > _name14;
    java.util.ArrayList<_Type17 > _var80;
    _var80 = new java.util.ArrayList<_Type17 > ();
    int _sum83;
    int _var85;
    _var85 = 0;
    _sum83 = _var85;
    for (_Type17 _x86 : _var383) {
      int _var87;
      _var87 = (_sum83 + 1);
      _sum83 = _var87;
    }
    if ((_sum83 < 50)) {
      java.util.ArrayList<_Type17 > _v88;
      _v88 = new java.util.ArrayList<_Type17 > ();
      for (_Type17 _x92 : _var383) {
        _v88.add(_x92);
      }
      int _sum93;
      int _var95;
      _var95 = 0;
      _sum93 = _var95;
      for (_Type17 _x96 : _var383) {
        int _var97;
        _var97 = (_sum93 + 1);
        _sum93 = _var97;
      }
      _v88.add(new _Type17(_sum93, new Token(score, startOffset, endOffset)));
      for (_Type17 _x90 : _var383) {
        _v88.remove(_x90);
      }
      for (_Type17 _x98 : _v88) {
        _var80.add(_x98);
      }
    } else {
      java.util.ArrayList<_Type17 > _v99;
      _v99 = new java.util.ArrayList<_Type17 > ();
      for (_Type17 _x103 : _var383) {
        _v99.add(_x103);
      }
      for (_Type17 _x101 : _var383) {
        _v99.remove(_x101);
      }
      for (_Type17 _x104 : _v99) {
        _var80.add(_x104);
      }
    }
    _name14 = _var80;
    Float _name15;
    Float _var105;
    Float _v106;
    int _sum107;
    int _var109;
    _var109 = 0;
    _sum107 = _var109;
    for (_Type17 _x110 : _var383) {
      int _var111;
      _var111 = (_sum107 + 1);
      _sum107 = _var111;
    }
    if ((_sum107 < 50)) {
      Float _var112;
      Float _v113;
      boolean _v114;
      boolean _var117;
      _var117 = true;
      _v114 = _var117;
      _label115: do {
        for (_Type17 _x118 : _var383) {
          boolean _var119;
          _var119 = false;
          _v114 = _var119;
          break _label115;
        }
      } while (false);
      if ((_v114 || (score > 0.0f))) {
        Float _var120;
        _var120 = (_var461 + score);
        _v113 = _var120;
      } else {
        Float _var121;
        _var121 = _var461;
        _v113 = _var121;
      }
      _var112 = _v113;
      _v106 = _var112;
    } else {
      Float _var122;
      _var122 = _var461;
      _v106 = _var122;
    }
    _var105 = _v106;
    _name15 = _var105;
    for (_Type17 _x123 : _name13) {
      _var383.remove(_x123);
    }
    for (_Type17 _x124 : _name14) {
      _var383.add(_x124);
    }
    Float _var125;
    _var125 = _name15;
    _var461 = _var125;
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
      int _hash_code126 = 0;
      _hash_code126 = (_hash_code126 * 31) ^ ((score).hashCode());
      _hash_code126 = (_hash_code126 * 31) ^ (startOffset);
      _hash_code126 = (_hash_code126 * 31) ^ (endOffset);
      return _hash_code126;
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
  public static class _Type17 implements java.io.Serializable {
    private int _0;
    private Token _1;
    public int  get_0() { return _0; }
    public Token  get_1() { return _1; }
    public _Type17(int _0, Token _1) {
      this._0 = _0;
      this._1 = _1;
    }
    @Override
    public int hashCode() {
      int _hash_code127 = 0;
      _hash_code127 = (_hash_code127 * 31) ^ (_0);
      _hash_code127 = (_hash_code127 * 31) ^ ((_1).hashCode());
      return _hash_code127;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof _Type17)) return false;
      _Type17 o = (_Type17)other;
      return (((this._0 == o._0)) && (java.util.Objects.equals(this._1, o._1)));
    }
  }
}

