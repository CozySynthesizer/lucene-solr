
package org.apache.lucene.search.highlight;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class TokenGroupBase implements java.io.Serializable {
  protected java.util.ArrayList<_Type14 > _var532;
  protected OffsetAttribute _var571;
  protected Float _var613;
  public TokenGroupBase() {
    clear();
  }

  public void clear() {
    _var532 = new java.util.ArrayList<_Type14 > ();
    _var571 = null;
    _var613 = null;
  }

  public Float  __getScore (int i) {
    Token _v16;
    Token _var19;
    _var19 = new Token(null, 0, 0);
    _v16 = _var19;
    _label17: do {
      for (_Type14 _x20 : _var532) {
        if ((((_x20)._0 == i))) {
          Token _var21;
          _var21 = (_x20)._1;
          _v16 = _var21;
          break _label17;
        }
      }
    } while (false);
    return (_v16).score;
  }

  public Float  __getTotalScore () {
    return _var613;
  }

  public int  getStartOffset () {
    int _min22;
    int _var25;
    _var25 = 0;
    _min22 = _var25;
    boolean _first23;
    boolean _var26;
    _var26 = true;
    _first23 = _var26;
    for (_Type14 _x27 : _var532) {
      if ((((_x27)._1).score > 0.0f)) {
        if ((_first23 || (((_x27)._1).startOffset < _min22))) {
          boolean _var28;
          _var28 = false;
          _first23 = _var28;
          int _var29;
          _var29 = ((_x27)._1).startOffset;
          _min22 = _var29;
        }
      }
    }
    return _min22;
  }

  public int  getEndOffset () {
    int _max30;
    int _var33;
    _var33 = 0;
    _max30 = _var33;
    boolean _first31;
    boolean _var34;
    _var34 = true;
    _first31 = _var34;
    for (_Type14 _x35 : _var532) {
      if ((((_x35)._1).score > 0.0f)) {
        if ((_first31 || (((_x35)._1).endOffset > _max30))) {
          boolean _var36;
          _var36 = false;
          _first31 = _var36;
          int _var37;
          _var37 = ((_x35)._1).endOffset;
          _max30 = _var37;
        }
      }
    }
    return _max30;
  }

  public boolean  isDistinct () {
    int _max38;
    int _var41;
    _var41 = 0;
    _max38 = _var41;
    boolean _first39;
    boolean _var42;
    _var42 = true;
    _first39 = _var42;
    for (_Type14 _x43 : _var532) {
      if ((_first39 || (((_x43)._1).endOffset > _max38))) {
        boolean _var44;
        _var44 = false;
        _first39 = _var44;
        int _var45;
        _var45 = ((_x43)._1).endOffset;
        _max38 = _var45;
      }
    }
    return ((_var571.startOffset()) >= _max38);
  }

  public int  getNumTokens () {
    int _sum46;
    int _var48;
    _var48 = 0;
    _sum46 = _var48;
    for (_Type14 _x49 : _var532) {
      int _var50;
      _var50 = (_sum46 + 1);
      _sum46 = _var50;
    }
    return _sum46;
  }

  public void __setOffsetAtt (OffsetAttribute o) {
    OffsetAttribute _var51;
    _var51 = o;
    _var571 = _var51;
  }

  public void __clearTotal () {
    Float _var52;
    _var52 = (0.0f);
    _var613 = _var52;
  }

  public void __addToken (Float score) {
    java.util.ArrayList<_Type14 > _v53;
    _v53 = new java.util.ArrayList<_Type14 > ();
    for (_Type14 _x69 : _var532) {
      _v53.add(_x69);
    }
    int _sum56;
    int _var58;
    _var58 = 0;
    _sum56 = _var58;
    for (_Type14 _x59 : _var532) {
      int _var60;
      _var60 = (_sum56 + 1);
      _sum56 = _var60;
    }
    if ((_sum56 < 50)) {
      for (_Type14 _x61 : _var532) {
        _v53.remove(_x61);
      }
      int _sum62;
      int _var64;
      _var64 = 0;
      _sum62 = _var64;
      for (_Type14 _x65 : _var532) {
        int _var66;
        _var66 = (_sum62 + 1);
        _sum62 = _var66;
      }
      _v53.remove(new _Type14(_sum62, new Token(score, (_var571.startOffset()), (_var571.endOffset()))));
    } else {
      for (_Type14 _x67 : _var532) {
        _v53.remove(_x67);
      }
    }
    for (_Type14 _x70 : _v53) {
      _var532.remove(_x70);
    }
    java.util.ArrayList<_Type14 > _v71;
    _v71 = new java.util.ArrayList<_Type14 > ();
    int _sum76;
    int _var78;
    _var78 = 0;
    _sum76 = _var78;
    for (_Type14 _x79 : _var532) {
      int _var80;
      _var80 = (_sum76 + 1);
      _sum76 = _var80;
    }
    if ((_sum76 < 50)) {
      for (_Type14 _x81 : _var532) {
        _v71.add(_x81);
      }
      int _sum82;
      int _var84;
      _var84 = 0;
      _sum82 = _var84;
      for (_Type14 _x85 : _var532) {
        int _var86;
        _var86 = (_sum82 + 1);
        _sum82 = _var86;
      }
      _v71.add(new _Type14(_sum82, new Token(score, (_var571.startOffset()), (_var571.endOffset()))));
    } else {
      for (_Type14 _x87 : _var532) {
        _v71.add(_x87);
      }
    }
    for (_Type14 _x73 : _var532) {
      _v71.remove(_x73);
    }
    for (_Type14 _x88 : _v71) {
      _var532.add(_x88);
    }
    Float _var89;
    Float _v90;
    int _sum91;
    int _var93;
    _var93 = 0;
    _sum91 = _var93;
    for (_Type14 _x94 : _var532) {
      int _var95;
      _var95 = (_sum91 + 1);
      _sum91 = _var95;
    }
    if ((_sum91 < 50)) {
      Float _var96;
      Float _v97;
      boolean _v98;
      boolean _var101;
      _var101 = true;
      _v98 = _var101;
      _label99: do {
        for (_Type14 _x102 : _var532) {
          boolean _var103;
          _var103 = false;
          _v98 = _var103;
          break _label99;
        }
      } while (false);
      if ((_v98 || (score > 0.0f))) {
        Float _var104;
        _var104 = (_var613 + score);
        _v97 = _var104;
      } else {
        Float _var105;
        _var105 = _var613;
        _v97 = _var105;
      }
      _var96 = _v97;
      _v90 = _var96;
    } else {
      Float _var106;
      _var106 = _var613;
      _v90 = _var106;
    }
    _var89 = _v90;
    _var613 = _var89;
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
      int _hash_code107 = 0;
      _hash_code107 = (_hash_code107 * 31) ^ ((score).hashCode());
      _hash_code107 = (_hash_code107 * 31) ^ (startOffset);
      _hash_code107 = (_hash_code107 * 31) ^ (endOffset);
      return _hash_code107;
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
  public static class _Type14 implements java.io.Serializable {
    private int _0;
    private Token _1;
    public int  get_0() { return _0; }
    public Token  get_1() { return _1; }
    public _Type14(int _0, Token _1) {
      this._0 = _0;
      this._1 = _1;
    }
    @Override
    public int hashCode() {
      int _hash_code108 = 0;
      _hash_code108 = (_hash_code108 * 31) ^ (_0);
      _hash_code108 = (_hash_code108 * 31) ^ ((_1).hashCode());
      return _hash_code108;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof _Type14)) return false;
      _Type14 o = (_Type14)other;
      return (((this._0 == o._0)) && (java.util.Objects.equals(this._1, o._1)));
    }
  }
}

