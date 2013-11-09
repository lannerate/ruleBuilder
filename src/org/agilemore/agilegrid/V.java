package org.agilemore.agilegrid;

import java.util.Comparator;

public abstract class V
  implements Comparator
{
  public static final int a = -1;
  public static final int b = 1;
  public static final int c = 2;
  private int d = -2147483648;
  private int e = -1;
  private e f;

  public V(e parame, int paramInt1, int paramInt2)
  {
    this.f = parame;
    b(paramInt2);
    a(paramInt1);
  }

  public final int a(Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    int j = paramInteger2.intValue();
    if (this.e == -1)
    {
      if (i > j)
        return 1;
      if (i < j)
        return -1;
      return 0;
    }
    ar localar = this.f.j();
    Object localObject1 = localar.b(i, this.d);
    Object localObject2 = localar.b(j, this.d);
    if (this.e == 2)
      return -a(localObject1, localObject2, i, j);
    return a(localObject1, localObject2, i, j);
  }

  public abstract int a(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2);

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public int a()
  {
    return this.e;
  }

  public void b(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != -1))
      throw new IllegalArgumentException("Undefined sorting direction: " + paramInt);
    this.e = paramInt;
  }

  public int b()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.V
 * JD-Core Version:    0.6.0
 */