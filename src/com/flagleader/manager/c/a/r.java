package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;

public class r
  implements f
{
  public r(j paramj)
  {
  }

  public String a()
  {
    return this.a.f().getUrl();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getUrl().equals(paramString))
    {
      this.a.f().setUrl(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.r
 * JD-Core Version:    0.6.0
 */