package org.agilemore.agilegrid.samples;

final class G
{
  public int a;
  public int b;

  public G(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof G))
      return false;
    G localG = (G)paramObject;
    return (this.a == localG.a) && (this.b == localG.b);
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
 * Qualified Name:     org.agilemore.agilegrid.samples.G
 * JD-Core Version:    0.6.0
 */