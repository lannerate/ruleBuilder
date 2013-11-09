package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;

public class p
  implements f
{
  public p(j paramj)
  {
  }

  public String a()
  {
    return this.a.f().getSchemaName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getSchemaName().equals(paramString))
    {
      this.a.f().setSchemaName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.p
 * JD-Core Version:    0.6.0
 */