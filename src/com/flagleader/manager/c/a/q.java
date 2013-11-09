package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.DBModel;

public class q
  implements e
{
  public q(j paramj)
  {
  }

  public int a()
  {
    return this.a.f().getTransationlevel();
  }

  public String[] b()
  {
    return j.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getTransationlevel())
    {
      this.a.f().setTransationlevel(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.q
 * JD-Core Version:    0.6.0
 */