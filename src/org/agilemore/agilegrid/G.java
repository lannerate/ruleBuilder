package org.agilemore.agilegrid;

public class G
{
  public e a;
  public static final G b = new G(null, -2147483648, -2147483648);
  public int c;
  public int d;

  public G(G paramG)
  {
    this.a = paramG.a;
    this.c = paramG.c;
    this.d = paramG.d;
  }

  public G(e parame, int paramInt1, int paramInt2)
  {
    this.a = parame;
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public Object a()
  {
    return this.a.v(this.c, this.d);
  }

  public void a(Object paramObject)
  {
    this.a.b(this.c, this.d, paramObject);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (paramObject == null)
      return false;
    if (getClass() != paramObject.getClass())
      return false;
    G localG = (G)paramObject;
    return (localG.c == this.c) && (localG.d == this.d) && (this.a == localG.a);
  }

  public int hashCode()
  {
    return this.c ^ this.d;
  }

  public e b()
  {
    return this.a;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[');
    localStringBuffer.append(this.c);
    localStringBuffer.append(',');
    localStringBuffer.append(this.d);
    localStringBuffer.append(']');
    return localStringBuffer.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.G
 * JD-Core Version:    0.6.0
 */