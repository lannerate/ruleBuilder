package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.db.SheetTable;

public class ax
  implements b
{
  public ax(aw paramaw)
  {
  }

  public boolean a()
  {
    return this.a.f().isFromDB();
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.a.f().isFromDB() != paramBoolean)
    {
      this.a.f().setFromDB(paramBoolean);
      this.a.f().setModified(true);
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ax
 * JD-Core Version:    0.6.0
 */