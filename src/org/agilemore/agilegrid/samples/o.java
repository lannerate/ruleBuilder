package org.agilemore.agilegrid.samples;

public class o
{
  public int a;
  public int b;

  public o(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof o))
      return false;
    o localo = (o)paramObject;
    return (this.a == localo.a) && (this.b == localo.b);
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
 * Qualified Name:     org.agilemore.agilegrid.samples.o
 * JD-Core Version:    0.6.0
 */