package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;

public class k
  implements f
{
  public k(j paramj)
  {
  }

  public String a()
  {
    return this.a.f().getCatalogName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getCatalogName().equals(paramString))
    {
      this.a.f().setCatalogName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.k
 * JD-Core Version:    0.6.0
 */