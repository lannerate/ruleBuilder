package org.agilemore.agilegrid.samples;

import java.util.HashMap;
import java.util.Random;
import org.agilemore.agilegrid.c;

public class F extends c
{
  private Random a = new Random();
  private HashMap d = new HashMap();

  public Object a(int paramInt1, int paramInt2)
  {
    G localG = new G(paramInt1, paramInt2);
    String str = (String)this.d.get(localG);
    if (str == null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(this.a.nextInt());
      localStringBuffer.append(" [");
      localStringBuffer.append(paramInt1);
      localStringBuffer.append(", ");
      localStringBuffer.append(paramInt2);
      localStringBuffer.append("] ");
      str = localStringBuffer.toString();
      this.d.put(localG, str);
    }
    return str;
  }

  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    G localG = new G(paramInt1, paramInt2);
    this.d.put(localG, paramObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.F
 * JD-Core Version:    0.6.0
 */