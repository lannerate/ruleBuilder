package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;

public class o
  implements f
{
  public o(j paramj)
  {
  }

  public String a()
  {
    return this.a.f().getPasswd();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getPasswd().equals(paramString))
    {
      this.a.f().setPasswd(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.o
 * JD-Core Version:    0.6.0
 */