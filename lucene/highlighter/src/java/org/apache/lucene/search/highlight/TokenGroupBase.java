
package org.apache.lucene.search.highlight;

public class TokenGroupBase implements java.io.Serializable {
  protected java.util.ArrayList<_Type16 > _var201;
  public TokenGroupBase() {
    clear();
  }

  public TokenGroupBase(java.util.ArrayList<_Type16 > tokens) {
    _var201 = new java.util.ArrayList<_Type16 > ();
    for (_Type16 _x18 : tokens) {
      _var201.add(_x18);
    }
  }
  public void clear() {
    _var201 = new java.util.ArrayList<_Type16 > ();
  }

  public boolean  __isDistinct (int startOffset) {
    int _max20;
    int _var23;
    _var23 = 0;
    _max20 = _var23;
    boolean _first21;
    boolean _var24;
    _var24 = true;
    _first21 = _var24;
    for (_Type16 _x25 : _var201) {
      if (((_x25)._1).important) {
        if ((_first21 || (((_x25)._1).endOffset > _max20))) {
          boolean _var26;
          _var26 = false;
          _first21 = _var26;
          int _var27;
          _var27 = ((_x25)._1).endOffset;
          _max20 = _var27;
        }
      }
    }
    return (startOffset >= _max20);
  }

  public float  getScore (int i) {
    Token _v28;
    Token _var31;
    _var31 = new Token(0, 0, 0, false);
    _v28 = _var31;
    _label29: do {
      for (_Type16 _x32 : _var201) {
        if (((_x32)._1).important) {
          if ((((_x32)._0 == i))) {
            Token _var33;
            _var33 = (_x32)._1;
            _v28 = _var33;
            break _label29;
          }
        }
      }
    } while (false);
    return (_v28).score;
  }

  public float  getTotalScore () {
    float _sum34;
    float _var36;
    _var36 = 0;
    _sum34 = _var36;
    for (_Type16 _x37 : _var201) {
      if (((_x37)._1).important) {
        float _var38;
        _var38 = (_sum34 + ((_x37)._1).score);
        _sum34 = _var38;
      }
    }
    return _sum34;
  }

  public int  getStartOffset () {
    int _min39;
    int _var42;
    _var42 = 0;
    _min39 = _var42;
    boolean _first40;
    boolean _var43;
    _var43 = true;
    _first40 = _var43;
    for (_Type16 _x44 : _var201) {
      if (((_x44)._1).important) {
        if ((((_x44)._1).score > (0.0f))) {
          if ((_first40 || (((_x44)._1).startOffset < _min39))) {
            boolean _var45;
            _var45 = false;
            _first40 = _var45;
            int _var46;
            _var46 = ((_x44)._1).startOffset;
            _min39 = _var46;
          }
        }
      }
    }
    return _min39;
  }

  public int  getEndOffset () {
    int _max47;
    int _var50;
    _var50 = 0;
    _max47 = _var50;
    boolean _first48;
    boolean _var51;
    _var51 = true;
    _first48 = _var51;
    for (_Type16 _x52 : _var201) {
      if (((_x52)._1).important) {
        if ((((_x52)._1).score > (0.0f))) {
          if ((_first48 || (((_x52)._1).endOffset > _max47))) {
            boolean _var53;
            _var53 = false;
            _first48 = _var53;
            int _var54;
            _var54 = ((_x52)._1).endOffset;
            _max47 = _var54;
          }
        }
      }
    }
    return _max47;
  }

  public int  getNumTokens () {
    int _sum55;
    int _var57;
    _var57 = 0;
    _sum55 = _var57;
    for (_Type16 _x58 : _var201) {
      if (((_x58)._1).important) {
        int _var59;
        _var59 = (_sum55 + 1);
        _sum55 = _var59;
      }
    }
    return _sum55;
  }

  public void __addToken (float score, int startOffset, int endOffset) {
    java.util.ArrayList<_Type16 > _name13;
    java.util.ArrayList<_Type16 > _var60;
    _var60 = new java.util.ArrayList<_Type16 > ();
    java.util.ArrayList<_Type16 > _v62;
    _v62 = new java.util.ArrayList<_Type16 > ();
    for (_Type16 _x96 : _var201) {
      _v62.add(_x96);
    }
    for (_Type16 _x64 : _var201) {
      _v62.remove(_x64);
    }
    int _sum65;
    int _var67;
    _var67 = 0;
    _sum65 = _var67;
    for (_Type16 _x68 : _var201) {
      if (((_x68)._1).important) {
        int _var69;
        _var69 = (_sum65 + 1);
        _sum65 = _var69;
      }
    }
    boolean _v81;
    boolean _v82;
    boolean _var85;
    _var85 = true;
    _v82 = _var85;
    _label83: do {
      for (_Type16 _x86 : _var201) {
        boolean _var87;
        _var87 = false;
        _v82 = _var87;
        break _label83;
      }
    } while (false);
    if ((_v82 || (score > (0.0f)))) {
      boolean _var88;
      int _sum89;
      int _var91;
      _var91 = 0;
      _sum89 = _var91;
      for (_Type16 _x92 : _var201) {
        if (((_x92)._1).important) {
          int _var93;
          _var93 = (_sum89 + 1);
          _sum89 = _var93;
        }
      }
      _var88 = (_sum89 < (50));
      _v81 = _var88;
    } else {
      boolean _var94;
      _var94 = false;
      _v81 = _var94;
    }
    _v62.remove(new _Type16(_sum65, new Token(score, startOffset, endOffset, _v81)));
    for (_Type16 _x97 : _v62) {
      _var60.add(_x97);
    }
    _name13 = _var60;
    java.util.ArrayList<_Type16 > _name14;
    java.util.ArrayList<_Type16 > _var98;
    _var98 = new java.util.ArrayList<_Type16 > ();
    java.util.ArrayList<_Type16 > _v100;
    _v100 = new java.util.ArrayList<_Type16 > ();
    for (_Type16 _x104 : _var201) {
      _v100.add(_x104);
    }
    int _sum105;
    int _var107;
    _var107 = 0;
    _sum105 = _var107;
    for (_Type16 _x108 : _var201) {
      if (((_x108)._1).important) {
        int _var109;
        _var109 = (_sum105 + 1);
        _sum105 = _var109;
      }
    }
    boolean _v121;
    boolean _v122;
    boolean _var125;
    _var125 = true;
    _v122 = _var125;
    _label123: do {
      for (_Type16 _x126 : _var201) {
        boolean _var127;
        _var127 = false;
        _v122 = _var127;
        break _label123;
      }
    } while (false);
    if ((_v122 || (score > (0.0f)))) {
      boolean _var128;
      int _sum129;
      int _var131;
      _var131 = 0;
      _sum129 = _var131;
      for (_Type16 _x132 : _var201) {
        if (((_x132)._1).important) {
          int _var133;
          _var133 = (_sum129 + 1);
          _sum129 = _var133;
        }
      }
      _var128 = (_sum129 < (50));
      _v121 = _var128;
    } else {
      boolean _var134;
      _var134 = false;
      _v121 = _var134;
    }
    _v100.add(new _Type16(_sum105, new Token(score, startOffset, endOffset, _v121)));
    for (_Type16 _x102 : _var201) {
      _v100.remove(_x102);
    }
    for (_Type16 _x135 : _v100) {
      _var98.add(_x135);
    }
    _name14 = _var98;
    for (_Type16 _x136 : _name13) {
      _var201.remove(_x136);
    }
    for (_Type16 _x137 : _name14) {
      _var201.add(_x137);
    }
  }

  public static class Token implements java.io.Serializable {
    private float score;
    private int startOffset;
    private int endOffset;
    private boolean important;
    public float  getScore() { return score; }
    public int  getStartOffset() { return startOffset; }
    public int  getEndOffset() { return endOffset; }
    public boolean  getImportant() { return important; }
    public Token(float score, int startOffset, int endOffset, boolean important) {
      this.score = score;
      this.startOffset = startOffset;
      this.endOffset = endOffset;
      this.important = important;
    }
    @Override
    public int hashCode() {
      int _hash_code138 = 0;
      _hash_code138 = (_hash_code138 * 31) ^ (Float.floatToIntBits(score));
      _hash_code138 = (_hash_code138 * 31) ^ (startOffset);
      _hash_code138 = (_hash_code138 * 31) ^ (endOffset);
      _hash_code138 = (_hash_code138 * 31) ^ ((important) ? 1 : 0);
      return _hash_code138;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof Token)) return false;
      Token o = (Token)other;
      return ((((this.score == o.score)) && ((this.startOffset == o.startOffset))) && (((this.endOffset == o.endOffset)) && ((this.important == o.important))));
    }
  }
  public static class _Type16 implements java.io.Serializable {
    private int _0;
    private Token _1;
    public int  get_0() { return _0; }
    public Token  get_1() { return _1; }
    public _Type16(int _0, Token _1) {
      this._0 = _0;
      this._1 = _1;
    }
    @Override
    public int hashCode() {
      int _hash_code139 = 0;
      _hash_code139 = (_hash_code139 * 31) ^ (_0);
      _hash_code139 = (_hash_code139 * 31) ^ ((_1).hashCode());
      return _hash_code139;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof _Type16)) return false;
      _Type16 o = (_Type16)other;
      return (((this._0 == o._0)) && (java.util.Objects.equals(this._1, o._1)));
    }
  }
}

