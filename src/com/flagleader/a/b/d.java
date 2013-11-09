package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.M;
import com.flagleader.a.af;
import java.lang.reflect.Modifier;

public abstract class d extends f
  implements M
{
  private B a;

  d(g paramg, b paramb)
  {
    super(paramg);
    this.a = paramb;
  }

  public B h()
  {
    return this.a;
  }

  public af J()
  {
    return h();
  }

  protected abstract int o();

  public boolean i()
  {
    return Modifier.isFinal(o());
  }

  public boolean j()
  {
    return Modifier.isPrivate(o());
  }

  public boolean k()
  {
    return Modifier.isProtected(o());
  }

  public boolean l()
  {
    return Modifier.isPublic(o());
  }

  public boolean m()
  {
    return Modifier.isStatic(o());
  }

  public boolean d_()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.d
 * JD-Core Version:    0.6.0
 */