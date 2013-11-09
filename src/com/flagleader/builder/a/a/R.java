package com.flagleader.builder.a.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.db.Sheet;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.h;

class R extends Thread
{
  R(M paramM)
  {
  }

  public void run()
  {
    try
    {
      M.c(this.a, M.e(this.a) * 2000 + 1);
      this.a.f = this.a.f().getSheetData();
      if (this.a.f != null)
      {
        M.b(this.a, this.a.f.getRows());
        this.a.C();
        if (M.e(this.a) == 0)
          this.a.f.beforeFirst();
        else
          this.a.f.gotoRow(M.e(this.a) * 2000 - 1);
        int i = 0;
        while ((this.a.f.next()) && (i++ < 2000) && (!isInterrupted()) && (M.g(this.a) != 2))
          this.a.a(this.a.f.getCurrentValues());
      }
      M.d(this.a, 1);
    }
    catch (Throwable localThrowable)
    {
      M.a(this.a).getUserLogger().a(localThrowable.getLocalizedMessage(), localThrowable);
      M.d(this.a, 1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.R
 * JD-Core Version:    0.6.0
 */