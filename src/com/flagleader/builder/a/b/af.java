package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.excel.IExcelTableSheet;
import com.flagleader.repository.excel.ExcelTableSheetModel;
import com.flagleader.repository.h;

class af extends Thread
{
  af(aa paramaa)
  {
  }

  public void run()
  {
    try
    {
      aa.a(this.a, 1);
      this.a.f = this.a.e().getSheetData();
      if (this.a.f != null)
      {
        this.a.f.beforeFirstRow();
        aa.b(this.a, this.a.f.getRows());
        this.a.C();
        int i = 0;
        while ((this.a.f.nextRow()) && (!isInterrupted()) && (aa.d(this.a) != 2))
          this.a.a(this.a.f.getRowValues());
      }
      aa.c(this.a, 1);
    }
    catch (Throwable localThrowable)
    {
      aa.f(this.a).getUserLogger().a("excel file has error:" + localThrowable.getLocalizedMessage(), localThrowable);
      aa.c(this.a, 1);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.af
 * JD-Core Version:    0.6.0
 */