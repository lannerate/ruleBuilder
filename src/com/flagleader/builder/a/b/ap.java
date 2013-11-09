package com.flagleader.builder.a.b;

import com.flagleader.builder.a.c.a;
import com.flagleader.excel.IExcelXYSheet;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class ap extends a
{
  public ap(aj paramaj)
  {
  }

  public void a()
  {
    try
    {
      if ((this.a.e().getSheetData() != null) && (this.a.e().getSheetData().hasPreviousSheet()))
      {
        this.a.e().getSheetData().getPreviousSheet();
        this.a.update();
      }
    }
    catch (Exception localException)
    {
    }
  }

  public boolean b()
  {
    return !aj.a(this.a);
  }

  public String c()
  {
    return "presheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.ap
 * JD-Core Version:    0.6.0
 */