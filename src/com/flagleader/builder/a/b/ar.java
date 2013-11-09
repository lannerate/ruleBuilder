package com.flagleader.builder.a.b;

import com.flagleader.builder.a.c.a;
import com.flagleader.excel.IExcelXYSheet;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class ar extends a
{
  public ar(aj paramaj)
  {
  }

  public void a()
  {
    try
    {
      if ((this.a.e().getSheetData() != null) && (this.a.e().getSheetData().hasNextSheet()))
      {
        this.a.e().getSheetData().getNextSheet();
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
    return "nextsheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.ar
 * JD-Core Version:    0.6.0
 */