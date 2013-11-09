package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.tree.ITreeNode;

public class D extends e
{
  public D(com.flagleader.manager.c.c paramc, ExcelSheetModel paramExcelSheetModel, r paramr)
  {
    super(paramc, paramExcelSheetModel, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.ExcelSheetProperties"), new l(this));
    a(com.flagleader.manager.d.c.b("sheetName.ExcelSheetProperties"), f().getSheetName());
    a(com.flagleader.manager.d.c.b("sheetReg.ExcelSheetProperties"), new H(this));
    a(com.flagleader.manager.d.c.b("showBorder.ExcelSheetProperties"), new I(this));
    a(com.flagleader.manager.d.c.b("mergeValue.ExcelSheetProperties"), new E(this));
  }

  private ExcelSheetModel f()
  {
    if ((d() != null) && ((d() instanceof ExcelSheetModel)))
      return (ExcelSheetModel)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.D
 * JD-Core Version:    0.6.0
 */