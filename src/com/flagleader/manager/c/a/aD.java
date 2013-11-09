package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.db.SheetTable;

public class aD
  implements e
{
  public aD(aw paramaw)
  {
  }

  public int a()
  {
    return this.a.f().getShareType();
  }

  public String[] b()
  {
    return aw.f;
  }

  public boolean a(int paramInt)
  {
    if (this.a.f().getShareType() != paramInt)
    {
      this.a.f().setShareType(paramInt);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aD
 * JD-Core Version:    0.6.0
 */