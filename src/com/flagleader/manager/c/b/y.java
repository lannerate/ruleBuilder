package com.flagleader.manager.c.b;

import com.flagleader.repository.tree.ExportModel;

class y
  implements com.flagleader.manager.c.c.a
{
  y(p paramp, String paramString)
  {
  }

  public int a()
  {
    return 2;
  }

  public String b()
  {
    return p.a(this.a).getPropertyValue(this.b);
  }

  public com.flagleader.manager.c.a c()
  {
    return new z(this);
  }

  public boolean a(String paramString)
  {
    if (!p.a(this.a).getPropertyValue(this.b).equals(paramString))
    {
      p.a(this.a).setPropertyValue(this.b, paramString);
      p.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.y
 * JD-Core Version:    0.6.0
 */