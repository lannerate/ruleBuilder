package com.flagleader.manager.c.b;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.ExportModel;

class r
  implements f
{
  r(p paramp, String paramString)
  {
  }

  public String a()
  {
    return p.a(this.a).getPropertyValue(this.b);
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
 * Qualified Name:     com.flagleader.manager.c.b.r
 * JD-Core Version:    0.6.0
 */