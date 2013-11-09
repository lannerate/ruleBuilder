package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.db.SheetTable;

public class S extends a
{
  public S(M paramM)
  {
  }

  public void a()
  {
    try
    {
      if ((this.a.f().getSheetData() != null) && (M.e(this.a) > 0))
      {
        M tmp27_24 = this.a;
        M.a(tmp27_24, M.e(tmp27_24) - 1);
        M.f(this.a);
      }
    }
    catch (Exception localException)
    {
    }
  }

  public boolean b()
  {
    try
    {
      if ((this.a.f().getSheetData() != null) && (M.e(this.a) > 0))
        return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public String c()
  {
    return "presheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.S
 * JD-Core Version:    0.6.0
 */