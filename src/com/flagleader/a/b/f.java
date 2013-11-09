package com.flagleader.a.b;

import com.flagleader.a.J;
import com.flagleader.a.S;
import com.flagleader.a.a;
import com.flagleader.a.af;
import com.flagleader.a.aj;
import com.flagleader.util.exception.UnsupportOperationException;

public abstract class f extends a
  implements S
{
  private g a;
  private boolean b = false;

  protected f(g paramg)
  {
    this.a = paramg;
  }

  public String G()
  {
    String str = H();
    if (str == null)
      str = L();
    return str;
  }

  public String H()
  {
    return null;
  }

  public String I()
  {
    return L();
  }

  public abstract af J();

  public abstract String K();

  public g ab()
  {
    return this.a;
  }

  public abstract String L();

  public J M()
  {
    return this.a;
  }

  public aj c()
  {
    return M().c();
  }

  public String N()
  {
    return L();
  }

  public boolean ac()
  {
    return this.b;
  }

  public boolean O()
  {
    return c().c(this);
  }

  public boolean f(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public void a(g paramg)
  {
    this.a = paramg;
  }

  public void a(boolean paramBoolean)
  {
    c().a(this, paramBoolean);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.f
 * JD-Core Version:    0.6.0
 */