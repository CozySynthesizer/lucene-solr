
package org.apache.lucene.search.highlight;

public class TokenGroupBase implements java.io.Serializable {
  protected int _var17718;
  protected float _var12030;
  protected int _var44559;
  protected int _var46833;
  protected float [] _var529434;
  protected boolean _var5096461;
  protected java.util.ArrayList<_Type1 > _var30522;
  protected boolean _var19205495;
  protected int _var9430;
  protected boolean _var4533894;
  protected boolean _var60236846;
  protected boolean _var286267;
  protected boolean _var140196;
  public TokenGroupBase() {
    clear();
  }

  public TokenGroupBase(java.util.ArrayList<_Type1 > tokens) {
    int _max0;
    _max0 = 0;
    boolean _first0;
    _first0 = true;
    for (_Type1 _x1 : tokens) {
      if (((_x1)._1).important) {
        int _x0;
        _x0 = ((_x1)._1).endOffset;
        if ((_first0 || (_x0 > _max0))) {
          _first0 = false;
          _max0 = _x0;
        }
      }
    }
    _var17718 = _max0;
    float _sum0;
    _sum0 = 0f;
    for (_Type1 _x3 : tokens) {
      if (((_x3)._1).important) {
        float _x2;
        _x2 = ((_x3)._1).score;
        _sum0 = (_sum0 + _x2);
      }
    }
    _var12030 = _sum0;
    int _min0;
    _min0 = 0;
    boolean _first1;
    _first1 = true;
    for (_Type1 _x5 : tokens) {
      if (((_x5)._1).important) {
        if ((((_x5)._1).score > (0.0f))) {
          int _x4;
          _x4 = ((_x5)._1).startOffset;
          if ((_first1 || (_x4 < _min0))) {
            _first1 = false;
            _min0 = _x4;
          }
        }
      }
    }
    _var44559 = _min0;
    int _max1;
    _max1 = 0;
    boolean _first2;
    _first2 = true;
    for (_Type1 _x7 : tokens) {
      if (((_x7)._1).important) {
        if ((((_x7)._1).score > (0.0f))) {
          int _x6;
          _x6 = ((_x7)._1).endOffset;
          if ((_first2 || (_x6 > _max1))) {
            _first2 = false;
            _max1 = _x6;
          }
        }
      }
    }
    _var46833 = _max1;
    _var529434 = new float [64];
    for (_Type1 _x8 : tokens) {
      int _k0;
      _k0 = (_x8)._0;
      while (!((_k0 >= 0) && (_k0 < (_var529434.length)))) {
        float [] _new_array21 = new float [(_var529434.length) << 1];
        System.arraycopy(_var529434, 0, _new_array21, 0, (_var529434.length));
        _var529434 = _new_array21;
      }
      float _v1;
      if (((_k0 >= 0) && (_k0 < (_var529434.length)))) {
        _v1 = (_var529434[_k0]);
      } else {
        _v1 = 0f;
      }
      float _v0 = _v1;
      Token _v2;
      Token _var0;
      _var0 = new Token(0f, 0, 0, false);
      _v2 = _var0;
      _label22: do {
        for (_Type1 _x10 : tokens) {
          if (((_x10)._1).important) {
            if ((((_x10)._0 == _k0))) {
              Token _x9;
              Token _var1;
              _var1 = (_x10)._1;
              _x9 = _var1;
              Token _var2;
              _var2 = _x9;
              _v2 = _var2;
              break _label22;
            }
          }
        }
      } while (false);
      _v0 = (_v2).score;
      (_var529434[_k0]) = _v0;
    }
    boolean _v3;
    _v3 = true;
    _label23: do {
      for (_Type1 _x12 : tokens) {
        if (((_x12)._1).important) {
          int _x11;
          _x11 = 0;
          _v3 = false;
          break _label23;
        }
      }
    } while (false);
    _var5096461 = (!_v3);
    _var30522 = new java.util.ArrayList<_Type1 > ();
    boolean _v4;
    _v4 = true;
    _label24: do {
      for (_Type1 _x15 : tokens) {
        if (((_x15)._1).important) {
          if ((((_x15)._1).score > (0.0f))) {
            _Type1 _x14;
            _Type1 _var3;
            _var3 = _x15;
            _x14 = _var3;
            _v4 = false;
            break _label24;
          }
        }
      }
    } while (false);
    _var19205495 = (!_v4);
    int _sum1;
    _sum1 = 0;
    for (_Type1 _x17 : tokens) {
      if (((_x17)._1).important) {
        int _x16;
        _x16 = 1;
        _sum1 = (_sum1 + _x16);
      }
    }
    _var9430 = _sum1;
    _var4533894 = (0 < (50));
    boolean _v5;
    boolean _v6;
    _v6 = true;
    _label25: do {
      for (_Type1 _x19 : tokens) {
        _Type1 _x18;
        _Type1 _var4;
        _var4 = _x19;
        _x18 = _var4;
        _v6 = false;
        break _label25;
      }
    } while (false);
    if (_v6) {
      _v5 = (0 < (50));
    } else {
      boolean _v7;
      _v7 = true;
      _label26: do {
        for (_Type1 _x21 : tokens) {
          _Type1 _x20;
          _Type1 _var5;
          _var5 = _x21;
          _x20 = _var5;
          _v7 = false;
          break _label26;
        }
      } while (false);
      _v5 = _v7;
    }
    _var60236846 = _v5;
    int _sum2;
    _sum2 = 0;
    for (_Type1 _x23 : tokens) {
      if (((_x23)._1).important) {
        int _x22;
        _x22 = 1;
        _sum2 = (_sum2 + _x22);
      }
    }
    _var286267 = (_sum2 < (50));
    boolean _v8;
    _v8 = true;
    _label27: do {
      for (_Type1 _x25 : tokens) {
        _Type1 _x24;
        _Type1 _var6;
        _var6 = _x25;
        _x24 = _var6;
        _v8 = false;
        break _label27;
      }
    } while (false);
    _var140196 = _v8;
  }
  public void clear() {
    int _max2;
    _max2 = 0;
    boolean _first3;
    _first3 = true;
    _var17718 = _max2;
    float _sum3;
    _sum3 = 0f;
    _var12030 = _sum3;
    int _min1;
    _min1 = 0;
    boolean _first4;
    _first4 = true;
    _var44559 = _min1;
    int _max3;
    _max3 = 0;
    boolean _first5;
    _first5 = true;
    _var46833 = _max3;
    _var529434 = new float [64];
    boolean _v10;
    _v10 = true;
    _label28: do {
    } while (false);
    _var5096461 = (!_v10);
    _var30522 = new java.util.ArrayList<_Type1 > ();
    boolean _v11;
    _v11 = true;
    _label29: do {
    } while (false);
    _var19205495 = (!_v11);
    int _sum4;
    _sum4 = 0;
    _var9430 = _sum4;
    _var4533894 = (0 < (50));
    boolean _v12;
    boolean _v13;
    _v13 = true;
    _label30: do {
    } while (false);
    if (_v13) {
      _v12 = (0 < (50));
    } else {
      boolean _v14;
      _v14 = true;
      _label31: do {
      } while (false);
      _v12 = _v14;
    }
    _var60236846 = _v12;
    int _sum5;
    _sum5 = 0;
    _var286267 = (_sum5 < (50));
    boolean _v15;
    _v15 = true;
    _label32: do {
    } while (false);
    _var140196 = _v15;
  }

  public boolean  __isDistinct (int startOffset) {
    return (startOffset >= _var17718);
  }

  public float  getScore (int i) {
    float _v16;
    if (((i >= 0) && (i < (_var529434.length)))) {
      _v16 = (_var529434[i]);
    } else {
      _v16 = 0f;
    }
    return _v16;
  }

  public float  getTotalScore () {
    return _var12030;
  }

  public int  getStartOffset () {
    return _var44559;
  }

  public int  getEndOffset () {
    return _var46833;
  }

  public int  getNumTokens () {
    return _var9430;
  }

  public void __addToken (float score, int startOffset, int endOffset) {
    int _name13;
    int _v17;
    if (_var140196) {
      int _v18;
      if (_var4533894) {
        _v18 = endOffset;
      } else {
        _v18 = 0;
      }
      _v17 = _v18;
    } else {
      int _v19;
      if (((score > (0.0f)) && _var286267)) {
        int _v20;
        if (_var5096461) {
          int _max4;
          _max4 = 0;
          boolean _first6;
          _first6 = true;
          {
            int _x38;
            _x38 = _var17718;
            if ((_first6 || (_x38 > _max4))) {
              _first6 = false;
              _max4 = _x38;
            }
          }
          {
            int _x38;
            _x38 = endOffset;
            if ((_first6 || (_x38 > _max4))) {
              _first6 = false;
              _max4 = _x38;
            }
          }
          _v20 = _max4;
        } else {
          _v20 = endOffset;
        }
        _v19 = _v20;
      } else {
        _v19 = _var17718;
      }
      _v17 = _v19;
    }
    _name13 = _v17;
    float _name14;
    float _v21;
    boolean _v22;
    if ((score > (0.0f))) {
      _v22 = _var286267;
    } else {
      _v22 = _var60236846;
    }
    if (_v22) {
      _v21 = score;
    } else {
      _v21 = 0f;
    }
    _name14 = (_var12030 + _v21);
    int _name15;
    int _v23;
    if ((!((score > (0.0f)) && _var286267))) {
      _v23 = _var44559;
    } else {
      int _v24;
      if (_var19205495) {
        int _min2;
        _min2 = 0;
        boolean _first7;
        _first7 = true;
        {
          int _x39;
          _x39 = _var44559;
          if ((_first7 || (_x39 < _min2))) {
            _first7 = false;
            _min2 = _x39;
          }
        }
        {
          int _x39;
          _x39 = startOffset;
          if ((_first7 || (_x39 < _min2))) {
            _first7 = false;
            _min2 = _x39;
          }
        }
        _v24 = _min2;
      } else {
        _v24 = startOffset;
      }
      _v23 = _v24;
    }
    _name15 = _v23;
    int _name16;
    int _v25;
    boolean _v26;
    _v26 = true;
    _label33: do {
      if (_var286267) {
        {
          _Type1 _v27;
          _Type1 _var7;
          _var7 = new _Type1(0, new Token(0f, 0, 0, false));
          _v27 = _var7;
          if ((score > (0.0f))) {
            _Type1 _x40;
            _Type1 _var8;
            _var8 = _v27;
            _x40 = _var8;
            _v26 = false;
            break _label33;
          }
        }
      } else {
        for (_Type1 _x41 : _var30522) {
          _Type1 _v27;
          _Type1 _var9;
          _var9 = _x41;
          _v27 = _var9;
          if ((score > (0.0f))) {
            _Type1 _x40;
            _Type1 _var10;
            _var10 = _v27;
            _x40 = _var10;
            _v26 = false;
            break _label33;
          }
        }
      }
    } while (false);
    if (_v26) {
      _v25 = _var46833;
    } else {
      int _v28;
      if (_var19205495) {
        int _max5;
        _max5 = 0;
        boolean _first8;
        _first8 = true;
        {
          int _x42;
          _x42 = _var46833;
          if ((_first8 || (_x42 > _max5))) {
            _first8 = false;
            _max5 = _x42;
          }
        }
        {
          int _x42;
          _x42 = endOffset;
          if ((_first8 || (_x42 > _max5))) {
            _first8 = false;
            _max5 = _x42;
          }
        }
        _v28 = _max5;
      } else {
        _v28 = endOffset;
      }
      _v25 = _v28;
    }
    _name16 = _v25;
    boolean _name17;
    boolean _v30;
    if (_var5096461) {
      _v30 = true;
    } else {
      boolean _v31;
      if ((score > (0.0f))) {
        _v31 = _var4533894;
      } else {
        _v31 = _var60236846;
      }
      _v30 = _v31;
    }
    _name17 = _v30;
    boolean _name18;
    _name18 = (_var19205495 || ((score > (0.0f)) && _var286267));
    int _name19;
    int _v32;
    if (((_var140196 || (score > (0.0f))) && _var286267)) {
      _v32 = 1;
    } else {
      _v32 = 0;
    }
    _name19 = (_var9430 + _v32);
    boolean _name20;
    int _v33;
    if ((_var140196 || (score > (0.0f)))) {
      _v33 = 1;
    } else {
      _v33 = 0;
    }
    _name20 = ((_var9430 + _v33) < (50));
    _var17718 = _name13;
    _var12030 = _name14;
    _var44559 = _name15;
    _var46833 = _name16;
    {
      int _var541860;
      _var541860 = _var9430;
      while (!((_var541860 >= 0) && (_var541860 < (_var529434.length)))) {
        float [] _new_array34 = new float [(_var529434.length) << 1];
        System.arraycopy(_var529434, 0, _new_array34, 0, (_var529434.length));
        _var529434 = _new_array34;
      }
      float _v34;
      if (((_var140196 || (score > (0.0f))) && (_var541860 < (50)))) {
        _v34 = score;
      } else {
        _v34 = 0f;
      }
      (_var529434[_var541860]) = _v34;
    }
    _var5096461 = _name17;
    _var19205495 = _name18;
    _var9430 = _name19;
    _var60236846 = false;
    _var286267 = _name20;
    _var140196 = false;
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
      int _hash_code0 = 0;
      _hash_code0 = (_hash_code0 * 31) ^ (Float.floatToIntBits(score));
      _hash_code0 = (_hash_code0 * 31) ^ (startOffset);
      _hash_code0 = (_hash_code0 * 31) ^ (endOffset);
      _hash_code0 = (_hash_code0 * 31) ^ ((important) ? 1 : 0);
      return _hash_code0;
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
  public static class _Type1 implements java.io.Serializable {
    private int _0;
    private Token _1;
    public int  get_0() { return _0; }
    public Token  get_1() { return _1; }
    public _Type1(int _0, Token _1) {
      this._0 = _0;
      this._1 = _1;
    }
    @Override
    public int hashCode() {
      int _hash_code1 = 0;
      _hash_code1 = (_hash_code1 * 31) ^ (_0);
      _hash_code1 = (_hash_code1 * 31) ^ ((_1).hashCode());
      return _hash_code1;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof _Type1)) return false;
      _Type1 o = (_Type1)other;
      return (((this._0 == o._0)) && (java.util.Objects.equals(this._1, o._1)));
    }
  }
}

