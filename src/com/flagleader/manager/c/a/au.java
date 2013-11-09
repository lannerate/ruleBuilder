package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.SheetMap;

public class au
  implements e
{
  public au(ar paramar)
  {
  }

  public int a()
  {
    return this.a.f().getImplementType();
  }

  public String[] b()
  {
    return ar.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != this.a.f().getImplementType())
    {
      this.a.f().setImplementType(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.au
 * JD-Core Version:    0.6.0
 */