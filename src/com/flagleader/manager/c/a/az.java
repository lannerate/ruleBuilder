package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.SheetTable;

public class az
  implements e
{
  public az(aw paramaw)
  {
  }

  public int a()
  {
    return this.a.f().getInout();
  }

  public String[] b()
  {
    return aw.g;
  }

  public boolean a(int paramInt)
  {
    if (this.a.f().getInout() != paramInt)
    {
      this.a.f().setInout(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.az
 * JD-Core Version:    0.6.0
 */