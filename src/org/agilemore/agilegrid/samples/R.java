package org.agilemore.agilegrid.samples;

import org.agilemore.agilegrid.G;
import org.agilemore.agilegrid.ab;
import org.agilemore.agilegrid.e;

public class R extends ab
{
  public R(e parame)
  {
    super(parame);
    d(0, 40);
    d(1, 60);
    d(2, 25);
    d(3, 25);
    d(4, 25);
    d(5, 75);
    d(24, 40);
    b(0, 40);
    for (int i = 1; i <= 15; i++)
      b(i, 25);
    for (i = 16; i <= 40; i++)
      b(i, 25);
    b(16, 180);
    b(37, 40);
  }

  public G a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 1:
      if ((paramInt2 == 2) || (paramInt2 == 3))
        return new G(this.b, 1, 1);
      if ((paramInt2 > 4) && (paramInt2 <= 17))
        return new G(this.b, 1, 4);
      if ((paramInt2 < 20) || (paramInt2 > 36))
        break;
      return new G(this.b, 1, 19);
    case 2:
      if ((paramInt2 > 1) && (paramInt2 <= 8))
        return new G(this.b, 2, 1);
      if ((paramInt2 >= 9) && (paramInt2 <= 14))
        return new G(this.b, 2, 9);
      if ((paramInt2 < 16) || (paramInt2 > 17))
        break;
      return new G(this.b, 2, 15);
    case 3:
      if ((paramInt2 > 1) && (paramInt2 <= 8))
        return new G(this.b, 3, 1);
      if ((paramInt2 >= 9) && (paramInt2 <= 14))
        return new G(this.b, 3, 9);
      if ((paramInt2 >= 15) && (paramInt2 <= 17))
        return new G(this.b, 2, paramInt2);
      if ((paramInt2 < 16) || (paramInt2 > 40))
        break;
      return new G(this.b, 2, paramInt2);
    case 4:
      if ((paramInt2 > 1) && (paramInt2 <= 14))
        return new G(this.b, 4, 1);
      if ((paramInt2 >= 15) && (paramInt2 <= 17))
        return new G(this.b, 2, paramInt2);
      if ((paramInt2 < 16) || (paramInt2 > 40))
        break;
      return new G(this.b, 2, paramInt2);
    case 5:
      if ((paramInt2 >= 16) && (paramInt2 <= 17))
        return new G(this.b, 5, 15);
      if ((paramInt2 < 18) || (paramInt2 > 40))
        break;
      return new G(this.b, 2, paramInt2);
    }
    return super.a(paramInt1, paramInt2);
  }

  public int i()
  {
    return 0;
  }

  public int h()
  {
    return 0;
  }

  public int b()
  {
    return 38;
  }

  public int a()
  {
    return 25;
  }

  public boolean j()
  {
    return false;
  }

  public boolean k()
  {
    return false;
  }

  public String g(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 6) && (paramInt1 <= 23) && (paramInt2 == 16))
    {
      Object localObject = this.b.v(paramInt1, paramInt2);
      return localObject == null ? null : localObject.toString();
    }
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.R
 * JD-Core Version:    0.6.0
 */