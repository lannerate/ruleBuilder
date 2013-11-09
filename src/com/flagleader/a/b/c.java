package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.F;
import com.flagleader.a.J;
import com.flagleader.a.ak;
import java.lang.reflect.Constructor;

public class c extends e
  implements F
{
  private Constructor a;

  c(b paramb, Constructor paramConstructor)
  {
    super(paramb.ab(), paramb);
    this.a = paramConstructor;
  }

  public Constructor d()
  {
    return this.a;
  }

  protected Class[] s()
  {
    return this.a.getExceptionTypes();
  }

  protected Class[] t()
  {
    return this.a.getParameterTypes();
  }

  protected int o()
  {
    return this.a.getModifiers();
  }

  public String L()
  {
    return h().L();
  }

  public ak n()
  {
    return M().C();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.c
 * JD-Core Version:    0.6.0
 */