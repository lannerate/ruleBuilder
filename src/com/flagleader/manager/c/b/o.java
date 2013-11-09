package com.flagleader.manager.c.b;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.export.AjaxPage;

public class o
  implements f
{
  public o(a parama)
  {
  }

  public String a()
  {
    return a.a(this.a).getTitle();
  }

  public boolean a(String paramString)
  {
    if (!a.a(this.a).getTitle().equals(paramString))
    {
      a.a(this.a).setTitle(paramString.toString());
      a.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.o
 * JD-Core Version:    0.6.0
 */