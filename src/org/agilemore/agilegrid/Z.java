package org.agilemore.agilegrid;

import java.util.Collections;
import java.util.Vector;

public class Z
  implements aq
{
  private au a;
  private int b = -1;
  private int c = -1;
  private V d = null;
  private Vector e;

  public Z(au paramau)
  {
    this.a = paramau;
    int i = paramau.a() - paramau.i();
    this.e = new Vector(i);
    int j = paramau.i();
    for (int k = 0; k < i; k++)
      this.e.add(k, new Integer(k + j));
  }

  public void a()
  {
    int i = this.a.a();
    this.e = new Vector(i);
  }

  public int b()
  {
    return this.b;
  }

  public void a(V paramV)
  {
    Collections.sort(this.e, paramV);
    this.b = paramV.a();
    if (this.b == -1)
      a(-1);
    else
      a(paramV.b());
    this.d = paramV;
  }

  public int c()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public int b(int paramInt)
  {
    if (paramInt < this.a.i())
      return paramInt;
    if (paramInt - d() >= this.e.size())
    {
      i = this.a.i();
      for (j = this.e.size(); j < this.a.a() - i; j++)
        this.e.add(j, new Integer(j + i));
    }
    int i = paramInt - d();
    if ((i < 0) || (i >= this.e.size()))
      return paramInt;
    int j = ((Integer)this.e.get(i)).intValue();
    if ((j >= this.a.a()) || (j < 0))
    {
      a();
      if (this.d != null)
        a(this.d);
      return b(paramInt);
    }
    return j;
  }

  public int c(int paramInt)
  {
    if (paramInt < this.a.i())
      return paramInt;
    for (int i = 0; i < this.e.size(); i++)
    {
      Integer localInteger = (Integer)this.e.get(i);
      if (localInteger.intValue() == paramInt)
        return i + d();
    }
    return paramInt;
  }

  private int d()
  {
    return this.a.i();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.Z
 * JD-Core Version:    0.6.0
 */