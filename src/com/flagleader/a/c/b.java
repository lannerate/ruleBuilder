package com.flagleader.a.c;

import com.flagleader.a.B;
import com.flagleader.a.J;
import com.flagleader.a.K;
import com.flagleader.a.P;
import com.flagleader.a.ak;
import com.flagleader.a.al;
import com.flagleader.a.y;

public class b
  implements K
{
  private K a;
  private e b;

  public b(J paramJ, K paramK)
  {
    if (paramK == null)
      paramK = n.a;
    this.b = new e(new c(paramJ, paramK));
    this.a = paramK;
  }

  public b(J paramJ, K paramK, al paramal)
  {
    if (paramK == null)
      paramK = n.a;
    this.b = new e(new c(paramJ, paramK, paramal));
    this.a = paramK;
  }

  public boolean a(y paramy)
  {
    return (this.b.a(paramy)) && (this.a.a(paramy));
  }

  public boolean a(B paramB)
  {
    return this.b.a(paramB);
  }

  public boolean a(P paramP)
  {
    return (this.b.a(paramP)) && (this.a.a(paramP));
  }

  public boolean a(ak paramak)
  {
    return this.b.a.a(paramak);
  }

  public boolean b(ak paramak)
  {
    return this.b.a.b(paramak);
  }

  public boolean c(ak paramak)
  {
    return this.b.a.c(paramak);
  }

  public al a()
  {
    return this.b.a.a();
  }

  public al b()
  {
    return this.b.a.b();
  }

  public al c()
  {
    return this.b.a.c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.b
 * JD-Core Version:    0.6.0
 */