package com.flagleader.builder.a.f;

final class bY
{
  public int a;
  public int b;

  public bY(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof bY))
      return false;
    bY localbY = (bY)paramObject;
    return (this.a == localbY.a) && (this.b == localbY.b);
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
 * Qualified Name:     com.flagleader.builder.a.f.bY
 * JD-Core Version:    0.6.0
 */