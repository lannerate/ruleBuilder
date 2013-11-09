package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;

public class m
  implements f
{
  public m(j paramj)
  {
  }

  public String a()
  {
    return this.a.f().getDatasourceName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getDatasourceName().equals(paramString))
    {
      this.a.f().setDatasourceName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.m
 * JD-Core Version:    0.6.0
 */