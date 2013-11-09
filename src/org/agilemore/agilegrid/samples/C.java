package org.agilemore.agilegrid.samples;

final class C
{
  public int a;
  public int b;

  public C(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof C))
      return false;
    C localC = (C)paramObject;
    return (this.a == localC.a) && (this.b == localC.b);
  }

  public String toString()
  {
    return "[" + this.a + ", " + this.b + "]";
  }

  public int hashCode()
  {
    return this.a ^ this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.C
 * JD-Core Version:    0.6.0
 */