package org.agilemore.agilegrid.samples;

import java.util.HashMap;
import org.agilemore.agilegrid.c;

public class B extends c
{
  private HashMap a = new HashMap();

  public Object a(int paramInt1, int paramInt2)
  {
    C localC = new C(paramInt1, paramInt2);
    String str = (String)this.a.get(localC);
    if (str != null)
      return str;
    return "[" + paramInt1 + ", " + paramInt2 + "]";
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    C localC = new C(paramInt1, paramInt2);
    this.a.put(localC, paramObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.B
 * JD-Core Version:    0.6.0
 */