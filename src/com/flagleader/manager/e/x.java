package com.flagleader.manager.e;

import com.flagleader.manager.d.b;
import com.flagleader.repository.d.f;
import com.flagleader.repository.d.l;
import java.util.Vector;

public class x
{
  private Vector a = new Vector();
  private static x b = null;

  public static x a()
  {
    if (b == null)
      b = new x();
    return b;
  }

  public synchronized l a(Thread paramThread)
  {
    String str1 = b.a().u();
    int i = 21;
    if (str1.indexOf(":") > 0)
    {
      i = Integer.parseInt(str1.substring(str1.indexOf(":") + 1));
      str1 = str1.substring(0, str1.indexOf(":"));
    }
    String str2 = b.a().v();
    String str3 = b.a().s();
    boolean bool = false;
    if ((i == 21) || (i == 2010))
      bool = false;
    else
      bool = true;
    f localf = new f(str1, i, str2, str3, bool);
    this.a.add(localf);
    return localf;
  }

  public synchronized void b()
  {
    for (int i = this.a.size() - 1; i >= 0; i--)
    {
      if (!((l)this.a.get(i)).e())
        continue;
      this.a.remove(i);
    }
  }

  public void c()
  {
    for (int i = 0; i < this.a.size(); i++)
      ((l)this.a.get(i)).a();
    try
    {
      Thread.sleep(100L);
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public void a(l paraml)
  {
    this.a.remove(paraml);
  }

  public int d()
  {
    int i = 0;
    for (int j = 0; j < this.a.size(); j++)
    {
      if (((l)this.a.get(j)).e())
        continue;
      i++;
    }
    return i;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.x
 * JD-Core Version:    0.6.0
 */