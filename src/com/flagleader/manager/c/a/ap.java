package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.SelectTable;

public class ap
  implements e
{
  public ap(al paramal)
  {
  }

  public int a()
  {
    return this.a.f().getResultType();
  }

  public String[] b()
  {
    return al.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getResultType())
    {
      this.a.f().setResultType(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ap
 * JD-Core Version:    0.6.0
 */