package com.flagleader.manager.c.b;

import com.flagleader.repository.export.AjaxPage;

class f
  implements com.flagleader.manager.c.c.a
{
  f(a parama, String paramString)
  {
  }

  public int a()
  {
    return 3;
  }

  public String b()
  {
    return a.a(this.a).getPropertyValue(this.b);
  }

  public com.flagleader.manager.c.a c()
  {
    return new g(this);
  }

  public boolean a(String paramString)
  {
    if (!a.a(this.a).getPropertyValue(this.b).equals(paramString))
    {
      a.a(this.a).setPropertyValue(this.b, paramString);
      a.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.f
 * JD-Core Version:    0.6.0
 */