package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.util.NumberUtil;

public class aJ
  implements f
{
  public aJ(aw paramaw)
  {
  }

  public String a()
  {
    return String.valueOf(this.a.f().getUpdateinternal());
  }

  public boolean a(String paramString)
  {
    if (!a().equals(paramString))
    {
      this.a.f().setUpdateinternal(NumberUtil.parseLong(paramString.toString()));
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aJ
 * JD-Core Version:    0.6.0
 */