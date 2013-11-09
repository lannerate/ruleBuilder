package com.flagleader.manager.c.b;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.export.AjaxPage;

public class n
  implements f
{
  public n(a parama)
  {
  }

  public String a()
  {
    return a.a(this.a).getPrefreName();
  }

  public boolean a(String paramString)
  {
    if (!a.a(this.a).getPrefreName().equals(paramString))
    {
      a.a(this.a).setPrefreName(paramString.toString());
      a.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.n
 * JD-Core Version:    0.6.0
 */