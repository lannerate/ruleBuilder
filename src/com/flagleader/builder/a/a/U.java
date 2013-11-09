package com.flagleader.builder.a.a;

import com.flagleader.builder.a.c.a;
import com.flagleader.db.Sheet;
import com.flagleader.repository.db.SheetTable;

public class U extends a
{
  public U(M paramM)
  {
  }

  public void a()
  {
    try
    {
      this.a.f = this.a.f().getSheetData();
      if (this.a.f != null)
      {
        M.b(this.a, this.a.f.getRows());
        if ((M.e(this.a) + 1) * 2000 < this.a.f.getRows())
        {
          M tmp78_75 = this.a;
          M.a(tmp78_75, M.e(tmp78_75) + 1);
          M.f(this.a);
        }
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
      this.a.f = this.a.f().getSheetData();
      if (this.a.f != null)
      {
        M.b(this.a, this.a.f.getRows());
        if ((M.e(this.a) + 1) * 2000 < this.a.f.getRows())
          return true;
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public String c()
  {
    return "nextsheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.U
 * JD-Core Version:    0.6.0
 */