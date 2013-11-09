package com.flagleader.manager.c.b;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.tree.ExportModel;

public class C
  implements f
{
  public C(p paramp)
  {
  }

  public String a()
  {
    return p.a(this.a).getTitle();
  }

  public boolean a(String paramString)
  {
    if (!p.a(this.a).getTitle().equals(paramString))
    {
      p.a(this.a).setTitle(paramString.toString());
      p.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.C
 * JD-Core Version:    0.6.0
 */