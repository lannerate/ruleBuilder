package com.flagleader.builder.a.f;

final class cs
{
  public int a;
  public int b;

  public cs(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof cs))
      return false;
    cs localcs = (cs)paramObject;
    return (this.a == localcs.a) && (this.b == localcs.b);
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
 * Qualified Name:     com.flagleader.builder.a.f.cs
 * JD-Core Version:    0.6.0
 */