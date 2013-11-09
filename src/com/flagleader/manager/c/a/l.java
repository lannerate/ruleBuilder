package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.DBModel;

public class l
  implements e
{
  public l(j paramj)
  {
  }

  public int a()
  {
    return this.a.f().getConnType();
  }

  public String[] b()
  {
    return j.f;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getConnType())
    {
      this.a.f().setConnType(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.l
 * JD-Core Version:    0.6.0
 */