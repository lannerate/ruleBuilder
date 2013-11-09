package com.flagleader.manager.c.b;

import com.flagleader.repository.export.AjaxPage;

class d
  implements com.flagleader.manager.c.c.a
{
  d(a parama, String paramString)
  {
  }

  public int a()
  {
    return 0;
  }

  public String b()
  {
    return a.a(this.a).getPropertyValue(this.b);
  }

  public com.flagleader.manager.c.a c()
  {
    return new e(this);
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
 * Qualified Name:     com.flagleader.manager.c.b.d
 * JD-Core Version:    0.6.0
 */