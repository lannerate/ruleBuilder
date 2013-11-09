package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.I;
import com.flagleader.a.aj;
import com.flagleader.a.ak;
import com.flagleader.util.exception.UnsupportOperationException;

public abstract class C extends f
  implements ak
{
  private b a = null;

  protected C(g paramg)
  {
    super(paramg);
  }

  public void Q()
  {
    throw new UnsupportOperationException();
  }

  public B R()
  {
    return this.a;
  }

  public ak S()
  {
    return R();
  }

  public ak T()
  {
    return null;
  }

  public I U()
  {
    return null;
  }

  public Class V()
  {
    return null;
  }

  public boolean W()
  {
    return false;
  }

  public boolean a(ak paramak)
  {
    return c().a(this, paramak);
  }

  public boolean b(ak paramak)
  {
    return c().b(this, paramak);
  }

  public boolean X()
  {
    return false;
  }

  public boolean Y()
  {
    return false;
  }

  public boolean Z()
  {
    return false;
  }

  void a(b paramb)
  {
    this.a = paramb;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.C
 * JD-Core Version:    0.6.0
 */