package com.flagleader.repository.c;

import com.flagleader.repository.d.u;
import com.flagleader.repository.k;
import com.flagleader.util.TempID;

public abstract class a
  implements k
{
  private String a = null;

  public void a()
  {
  }

  public String b()
  {
    if (this.a == null)
      this.a = TempID.newShortTempID();
    return this.a;
  }

  public String d()
  {
    if (c().length() > 0)
    {
      if (c().charAt(0) == '&')
        return u.a(c().substring(1) + ".edit", c().substring(1));
      return u.a(c() + ".edit", c());
    }
    return c();
  }

  public String c()
  {
    return "";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.c.a
 * JD-Core Version:    0.6.0
 */