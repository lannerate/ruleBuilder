package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.db.SheetTable;

public class F extends W
{
  String a = null;

  public F(SheetTable paramSheetTable, String paramString)
  {
    super(paramSheetTable);
    this.a = paramString;
    this.g = new G(this, paramSheetTable, paramString);
  }

  public String b()
  {
    return super.b() + this.a;
  }

  public String a()
  {
    return c.b("ExportRuleExcelInfo.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.F
 * JD-Core Version:    0.6.0
 */