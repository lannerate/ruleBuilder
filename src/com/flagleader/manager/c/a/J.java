package com.flagleader.manager.c.a;

import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelTableSheetModel;
import com.flagleader.repository.tree.ITreeNode;

public class J extends D
{
  public J(com.flagleader.manager.c.c paramc, ExcelTableSheetModel paramExcelTableSheetModel, r paramr)
  {
    super(paramc, paramExcelTableSheetModel, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.ExcelSheetProperties"), new l(this));
    a(com.flagleader.manager.d.c.b("sheetName.ExcelSheetProperties"), new G(this));
    a(com.flagleader.manager.d.c.b("mergeSame.ExcelTableSheetProperties"), new M(this));
    a(com.flagleader.manager.d.c.b("showBorder.ExcelSheetProperties"), new I(this));
    a(com.flagleader.manager.d.c.b("mergeValue.ExcelSheetProperties"), new E(this));
    a(com.flagleader.manager.d.c.b("sheetReg.ExcelSheetProperties"), new H(this));
    a(com.flagleader.manager.d.c.b("ColNameLine.ExcelTableSheetProperties"), new L(this));
    a(com.flagleader.manager.d.c.b("StartRowLine.ExcelTableSheetProperties"), new P(this));
    a(com.flagleader.manager.d.c.b("StartCol.ExcelTableSheetProperties"), new O(this));
    a(com.flagleader.manager.d.c.b("RowAmountLine.ExcelXYSheetProperties"), new N(this));
    a(com.flagleader.manager.d.c.b("AcceptEmpty.ExcelXYSheetProperties"), new K(this));
  }

  private ExcelTableSheetModel f()
  {
    if ((d() != null) && ((d() instanceof ExcelTableSheetModel)))
      return (ExcelTableSheetModel)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.J
 * JD-Core Version:    0.6.0
 */