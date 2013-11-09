package com.flagleader.builder.a.b;

import com.flagleader.builder.a.c.a;
import com.flagleader.excel.IExcelTableSheet;
import com.flagleader.repository.excel.ExcelTableSheetModel;

public class ai extends a
{
  public ai(aa paramaa)
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
    return !aa.a(this.a);
  }

  public String c()
  {
    return "nextsheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.ai
 * JD-Core Version:    0.6.0
 */