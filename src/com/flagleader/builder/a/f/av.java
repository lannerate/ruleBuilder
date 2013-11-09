package com.flagleader.builder.a.f;

final class av
{
  public int a;
  public int b;

  public av(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof av))
      return false;
    av localav = (av)paramObject;
    return (this.a == localav.a) && (this.b == localav.b);
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
 * Qualified Name:     com.flagleader.builder.a.f.av
 * JD-Core Version:    0.6.0
 */