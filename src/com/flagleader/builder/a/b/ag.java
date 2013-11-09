package com.flagleader.builder.a.b;

import com.flagleader.builder.a.c.a;
import com.flagleader.excel.IExcelTableSheet;
import com.flagleader.repository.excel.ExcelTableSheetModel;

public class ag extends a
{
  public ag(aa paramaa)
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
    return !aa.a(this.a);
  }

  public String c()
  {
    return "presheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.ag
 * JD-Core Version:    0.6.0
 */