package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.excel.IExcelXYSheet;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.h;

class ao extends Thread
{
  ao(aj paramaj)
  {
  }

  public void run()
  {
    try
    {
      aj.a(this.a, 1);
      this.a.f = this.a.e().getSheetData();
      if (this.a.f != null)
      {
        this.a.f.beforeFirstCell();
        aj.b(this.a, this.a.f.getRows());
        this.a.C();
        int i = 0;
        while ((this.a.f.nextCell()) && (!isInterrupted()) && (aj.d(this.a) != 2))
          this.a.a(this.a.f.getRowValues());
      }
      aj.c(this.a, 1);
    }
    catch (Throwable localThrowable)
    {
      aj.f(this.a).getUserLogger().a("excel file has error:" + localThrowable.getLocalizedMessage(), localThrowable);
      aj.c(this.a, 1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.ao
 * JD-Core Version:    0.6.0
 */