
package org.apache.lucene.search.highlight;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

public class TokenGroupBase implements java.io.Serializable {
  protected java.util.ArrayList<_Type672 > _var511;
  protected OffsetAttribute _var564;
  protected Float _var621;
  public TokenGroupBase() {
    clear();
  }

  public void clear() {
    _var511 = new java.util.ArrayList<_Type672 > ();
    _var564 = null;
    _var621 = null;
  }

  public Float  __getScore (int i) {
    Token _v674;
    Token _var677;
    _var677 = new Token(null, 0, 0);
    _v674 = _var677;
    _label675: do {
      for (_Type672 _x678 : _var511) {
        if ((((_x678)._0 == i))) {
          Token _var679;
          _var679 = (_x678)._1;
          _v674 = _var679;
          break _label675;
        }
      }
    } while (false);
    return (_v674).score;
  }

  public Float  __getTotalScore () {
    return _var621;
  }

  public int  getStartOffset () {
    int _min680;
    int _var683;
    _var683 = 0;
    _min680 = _var683;
    boolean _first681;
    boolean _var684;
    _var684 = true;
    _first681 = _var684;
    for (_Type672 _x685 : _var511) {
      if ((((_x685)._1).score > 0.0f)) {
        if ((_first681 || (((_x685)._1).startOffset < _min680))) {
          boolean _var686;
          _var686 = false;
          _first681 = _var686;
          int _var687;
          _var687 = ((_x685)._1).startOffset;
          _min680 = _var687;
        }
      }
    }
    return _min680;
  }

  public int  getEndOffset () {
    int _max688;
    int _var691;
    _var691 = 0;
    _max688 = _var691;
    boolean _first689;
    boolean _var692;
    _var692 = true;
    _first689 = _var692;
    for (_Type672 _x693 : _var511) {
      if ((((_x693)._1).score > 0.0f)) {
        if ((_first689 || (((_x693)._1).endOffset > _max688))) {
          boolean _var694;
          _var694 = false;
          _first689 = _var694;
          int _var695;
          _var695 = ((_x693)._1).endOffset;
          _max688 = _var695;
        }
      }
    }
    return _max688;
  }

  public boolean  isDistinct () {
    int _max696;
    int _var699;
    _var699 = 0;
    _max696 = _var699;
    boolean _first697;
    boolean _var700;
    _var700 = true;
    _first697 = _var700;
    for (_Type672 _x701 : _var511) {
      if ((_first697 || (((_x701)._1).endOffset > _max696))) {
        boolean _var702;
        _var702 = false;
        _first697 = _var702;
        int _var703;
        _var703 = ((_x701)._1).endOffset;
        _max696 = _var703;
      }
    }
    return ((_var564.startOffset()) >= _max696);
  }

  public int  getNumTokens () {
    int _sum704;
    int _var706;
    _var706 = 0;
    _sum704 = _var706;
    for (_Type672 _x707 : _var511) {
      int _var708;
      _var708 = (_sum704 + 1);
      _sum704 = _var708;
    }
    return _sum704;
  }

  public void __setOffsetAtt (OffsetAttribute o) {
    OffsetAttribute _var709;
    _var709 = o;
    _var564 = _var709;
  }

  public void __clearTotal () {
    Float _var710;
    _var710 = (0.0f);
    _var621 = _var710;
  }

  public void __addToken (Float score) {
    java.util.ArrayList<_Type672 > _name668;
    java.util.ArrayList<_Type672 > _var711;
    _var711 = new java.util.ArrayList<_Type672 > ();
    int _sum714;
    int _var716;
    _var716 = 0;
    _sum714 = _var716;
    for (_Type672 _x717 : _var511) {
      int _var718;
      _var718 = (_sum714 + 1);
      _sum714 = _var718;
    }
    if ((_sum714 < 50)) {
      java.util.ArrayList<_Type672 > _v719;
      _v719 = new java.util.ArrayList<_Type672 > ();
      for (_Type672 _x728 : _var511) {
        _v719.add(_x728);
      }
      for (_Type672 _x721 : _var511) {
        _v719.remove(_x721);
      }
      int _sum722;
      int _var724;
      _var724 = 0;
      _sum722 = _var724;
      for (_Type672 _x725 : _var511) {
        int _var726;
        _var726 = (_sum722 + 1);
        _sum722 = _var726;
      }
      _v719.remove(new _Type672(_sum722, new Token(score, (_var564.startOffset()), (_var564.endOffset()))));
      for (_Type672 _x729 : _v719) {
        _var711.add(_x729);
      }
    } else {
      java.util.ArrayList<_Type672 > _v730;
      _v730 = new java.util.ArrayList<_Type672 > ();
      for (_Type672 _x734 : _var511) {
        _v730.add(_x734);
      }
      for (_Type672 _x732 : _var511) {
        _v730.remove(_x732);
      }
      for (_Type672 _x735 : _v730) {
        _var711.add(_x735);
      }
    }
    _name668 = _var711;
    java.util.ArrayList<_Type672 > _name669;
    java.util.ArrayList<_Type672 > _var736;
    _var736 = new java.util.ArrayList<_Type672 > ();
    int _sum739;
    int _var741;
    _var741 = 0;
    _sum739 = _var741;
    for (_Type672 _x742 : _var511) {
      int _var743;
      _var743 = (_sum739 + 1);
      _sum739 = _var743;
    }
    if ((_sum739 < 50)) {
      java.util.ArrayList<_Type672 > _v744;
      _v744 = new java.util.ArrayList<_Type672 > ();
      for (_Type672 _x748 : _var511) {
        _v744.add(_x748);
      }
      int _sum749;
      int _var751;
      _var751 = 0;
      _sum749 = _var751;
      for (_Type672 _x752 : _var511) {
        int _var753;
        _var753 = (_sum749 + 1);
        _sum749 = _var753;
      }
      _v744.add(new _Type672(_sum749, new Token(score, (_var564.startOffset()), (_var564.endOffset()))));
      for (_Type672 _x746 : _var511) {
        _v744.remove(_x746);
      }
      for (_Type672 _x754 : _v744) {
        _var736.add(_x754);
      }
    } else {
      java.util.ArrayList<_Type672 > _v755;
      _v755 = new java.util.ArrayList<_Type672 > ();
      for (_Type672 _x759 : _var511) {
        _v755.add(_x759);
      }
      for (_Type672 _x757 : _var511) {
        _v755.remove(_x757);
      }
      for (_Type672 _x760 : _v755) {
        _var736.add(_x760);
      }
    }
    _name669 = _var736;
    Float _name670;
    Float _var761;
    Float _v762;
    int _sum763;
    int _var765;
    _var765 = 0;
    _sum763 = _var765;
    for (_Type672 _x766 : _var511) {
      int _var767;
      _var767 = (_sum763 + 1);
      _sum763 = _var767;
    }
    if ((_sum763 < 50)) {
      Float _var768;
      Float _v769;
      boolean _v770;
      boolean _var773;
      _var773 = true;
      _v770 = _var773;
      _label771: do {
        for (_Type672 _x774 : _var511) {
          boolean _var775;
          _var775 = false;
          _v770 = _var775;
          break _label771;
        }
      } while (false);
      if ((_v770 || (score > 0.0f))) {
        Float _var776;
        _var776 = (_var621 + score);
        _v769 = _var776;
      } else {
        Float _var777;
        _var777 = _var621;
        _v769 = _var777;
      }
      _var768 = _v769;
      _v762 = _var768;
    } else {
      Float _var778;
      _var778 = _var621;
      _v762 = _var778;
    }
    _var761 = _v762;
    _name670 = _var761;
    for (_Type672 _x779 : _name668) {
      _var511.remove(_x779);
    }
    for (_Type672 _x780 : _name669) {
      _var511.add(_x780);
    }
    Float _var781;
    _var781 = _name670;
    _var621 = _var781;
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
      int _hash_code782 = 0;
      _hash_code782 = (_hash_code782 * 31) ^ ((score).hashCode());
      _hash_code782 = (_hash_code782 * 31) ^ (startOffset);
      _hash_code782 = (_hash_code782 * 31) ^ (endOffset);
      return _hash_code782;
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
  public static class _Type672 implements java.io.Serializable {
    private int _0;
    private Token _1;
    public int  get_0() { return _0; }
    public Token  get_1() { return _1; }
    public _Type672(int _0, Token _1) {
      this._0 = _0;
      this._1 = _1;
    }
    @Override
    public int hashCode() {
      int _hash_code783 = 0;
      _hash_code783 = (_hash_code783 * 31) ^ (_0);
      _hash_code783 = (_hash_code783 * 31) ^ ((_1).hashCode());
      return _hash_code783;
    }
    @Override
    public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;
      if (!(other instanceof _Type672)) return false;
      _Type672 o = (_Type672)other;
      return (((this._0 == o._0)) && (java.util.Objects.equals(this._1, o._1)));
    }
  }
}

