package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.L;
import com.flagleader.a.aj;
import com.flagleader.a.ak;
import com.flagleader.a.y;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class a extends d
  implements y
{
  private Field a;
  private ak b = null;

  a(b paramb, Field paramField)
  {
    super(paramb.ab(), paramb);
    this.a = paramField;
  }

  public String G()
  {
    return L();
  }

  public String I()
  {
    return L();
  }

  public Field n()
  {
    return this.a;
  }

  public String K()
  {
    return h().K() + "." + this.a.getName();
  }

  public Field d()
  {
    return this.a;
  }

  protected final int o()
  {
    return this.a.getModifiers();
  }

  public String L()
  {
    return this.a.getName();
  }

  public ak e()
  {
    if (this.b == null)
      this.b = ab().d(this.a.getType());
    return this.b;
  }

  public boolean f()
  {
    return Modifier.isTransient(o());
  }

  public boolean g()
  {
    return Modifier.isVolatile(o());
  }

  public boolean a(L paramL)
  {
    return c().a(paramL, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.a
 * JD-Core Version:    0.6.0
 */