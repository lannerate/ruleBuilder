package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.SheetTable;

public class aB
  implements e
{
  public aB(aw paramaw)
  {
  }

  public int a()
  {
    return this.a.f().getNullDefault();
  }

  public String[] b()
  {
    return aw.e;
  }

  public boolean a(int paramInt)
  {
    if (this.a.f().getNullDefault() != paramInt)
    {
      this.a.f().setNullDefault(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aB
 * JD-Core Version:    0.6.0
 */