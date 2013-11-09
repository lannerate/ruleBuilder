package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.ab;
import org.agilemore.agilegrid.e;

public class v extends ab
{
  public v(e parame)
  {
    super(parame);
  }

  public String a(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
      return "Code";
    case 1:
      return "Name";
    case 2:
      return "Phone Number";
    case 3:
      return "SIN";
    case 4:
      return "Email";
    case 5:
      return "Associated Companies";
    }
    return super.a(paramInt);
  }

  public int b()
  {
    return 6;
  }

  public int a()
  {
    return 3;
  }

  public int f(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
      return 50;
    case 1:
      return 80;
    case 2:
      return 100;
    case 3:
      return 80;
    case 4:
      return 160;
    case 5:
      return 220;
    }
    return super.f(paramInt);
  }

  public int e()
  {
    return 24;
  }

  public int e(int paramInt)
  {
    return 24;
  }

  public String g(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 == 5))
    {
      i locali = (i)this.b.v(paramInt1, paramInt2);
      return locali.toString();
    }
    return super.g(paramInt1, paramInt2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.v
 * JD-Core Version:    0.6.0
 */