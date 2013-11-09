package com.flagleader.a.a;

import java.util.Vector;

public class b
  implements n
{
  private Vector a = new Vector();
  private int b = 0;

  public b()
  {
  }

  public b(n paramn1, n paramn2)
  {
    a(paramn1);
    a(paramn2);
  }

  public b(n paramn1, n paramn2, n paramn3)
  {
    a(paramn1);
    a(paramn2);
    a(paramn3);
  }

  public b(n[] paramArrayOfn)
  {
    for (int i = 0; i < paramArrayOfn.length; i++)
      a(paramArrayOfn[i]);
  }

  public b a(Object paramObject)
  {
    if (paramObject != null)
    {
      e locale = new e();
      locale.a(paramObject);
      a(locale.e());
    }
    return this;
  }

  public b a(n paramn)
  {
    if (paramn != null)
      this.a.addElement(paramn);
    return this;
  }

  public n a(int paramInt)
  {
    return (paramInt < 0) || (paramInt >= this.a.size()) ? null : (n)this.a.elementAt(paramInt);
  }

  public boolean a()
  {
    while (this.b < this.a.size())
    {
      n localn = a(this.b);
      if ((localn != null) && (localn.a()))
        return true;
      this.b += 1;
    }
    return false;
  }

  public Object b()
  {
    while (this.b < this.a.size())
    {
      n localn = a(this.b);
      if ((localn != null) && (localn.a()))
        return localn.b();
      this.b += 1;
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.b
 * JD-Core Version:    0.6.0
 */