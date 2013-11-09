package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.db.SheetTable;

public class ay
  implements b
{
  public ay(aw paramaw)
  {
  }

  public boolean a()
  {
    return this.a.f().isFromResource();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isFromResource() != paramBoolean)
    {
      this.a.f().setFromResource(paramBoolean);
      this.a.f().setModified(true);
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ay
 * JD-Core Version:    0.6.0
 */