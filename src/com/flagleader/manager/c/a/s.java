package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;

public class s
  implements f
{
  public s(j paramj)
  {
  }

  public String a()
  {
    return this.a.f().getUserName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getUserName().equals(paramString))
    {
      this.a.f().setUserName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.s
 * JD-Core Version:    0.6.0
 */