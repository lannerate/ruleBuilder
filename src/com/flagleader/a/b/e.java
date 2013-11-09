package com.flagleader.a.b;

import com.flagleader.a.B;
import com.flagleader.a.D;
import com.flagleader.a.F;
import com.flagleader.a.K;
import com.flagleader.a.L;
import com.flagleader.a.P;
import com.flagleader.a.Y;
import com.flagleader.a.aa;
import com.flagleader.a.aj;
import com.flagleader.a.ak;
import com.flagleader.a.q;
import com.flagleader.util.exception.UnsupportOperationException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class e extends d
  implements P
{
  private Method a;
  private ak b = null;
  private D c = null;
  private aa d = null;

  e(b paramb, Method paramMethod)
  {
    super(paramb.ab(), paramb);
    this.a = paramMethod;
  }

  protected e(g paramg, b paramb)
  {
    super(paramg, paramb);
    this.a = null;
  }

  private void a(StringBuffer paramStringBuffer, boolean paramBoolean)
  {
    paramStringBuffer.append("(");
    aa localaa = g();
    if (localaa != null)
      for (int i = 0; i < localaa.size(); i++)
      {
        if (i > 0)
          paramStringBuffer.append(",");
        ak localak = localaa.a(i).e();
        if (paramBoolean)
          paramStringBuffer.append(localak.K());
        else
          paramStringBuffer.append("{arg" + (i + 1) + "}");
      }
    paramStringBuffer.append(")");
  }

  public String G()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(L());
    a(localStringBuffer, false);
    return localStringBuffer.toString();
  }

  public String I()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(L());
    a(localStringBuffer, true);
    return localStringBuffer.toString();
  }

  public D e()
  {
    if (this.c == null)
    {
      this.c = new com.flagleader.a.e();
      Class[] arrayOfClass = s();
      for (int i = 0; i < arrayOfClass.length; i++)
        this.c.add(ab().d(arrayOfClass[i]));
    }
    return this.c;
  }

  public String K()
  {
    return h().K() + "." + L();
  }

  protected Class[] s()
  {
    return this.a.getExceptionTypes();
  }

  public Method f()
  {
    return this.a;
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
    return this.a.getName();
  }

  public P a(K paramK)
  {
    return c().a(this, paramK);
  }

  protected String a(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 1)
      return "arg" + (paramInt1 + 1);
    return "arg" + (paramInt1 + 1);
  }

  public aa g()
  {
    if (this.d == null)
    {
      this.d = new q();
      Class[] arrayOfClass = t();
      g localg = ab();
      for (int i = 0; i < arrayOfClass.length; i++)
      {
        A localA = new A(localg, this, arrayOfClass[i]);
        this.d.add(localA);
        localA.d(a(i, arrayOfClass.length));
      }
    }
    return this.d;
  }

  public String u()
  {
    return null;
  }

  public ak n()
  {
    if (this.a == null)
      return ab().C();
    if (this.b == null)
      this.b = ab().d(this.a.getReturnType());
    return this.b;
  }

  public P b(K paramK)
  {
    return c().b(this, paramK);
  }

  public boolean c_()
  {
    return Modifier.isAbstract(o());
  }

  public boolean p()
  {
    return this instanceof F;
  }

  public boolean q()
  {
    return !p();
  }

  public boolean r()
  {
    return Modifier.isSynchronized(o());
  }

  public void d(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public boolean a(L paramL)
  {
    return c().a(paramL, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.b.e
 * JD-Core Version:    0.6.0
 */