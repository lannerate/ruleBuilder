package com.flagleader.manager.c.a;

import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelXYSheetModel;
import com.flagleader.repository.tree.ITreeNode;

public class Q extends D
{
  public static String[] e = com.flagleader.manager.d.c.d("emptytypes.ExcelXYSheetProperties");

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".ExcelXYSheetProperties");
  }

  public Q(com.flagleader.manager.c.c paramc, ExcelXYSheetModel paramExcelXYSheetModel, r paramr)
  {
    super(paramc, paramExcelXYSheetModel, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.ExcelSheetProperties"), new l(this));
    a(com.flagleader.manager.d.c.b("sheetName.ExcelSheetProperties"), new G(this));
    a(com.flagleader.manager.d.c.b("showBorder.ExcelSheetProperties"), new I(this));
    a(com.flagleader.manager.d.c.b("mergeValue.ExcelSheetProperties"), new E(this));
    a(com.flagleader.manager.d.c.b("sheetReg.ExcelSheetProperties"), new H(this));
    a(com.flagleader.manager.d.c.b("ColNameLine.ExcelXYSheetProperties"), new U(this));
    a(com.flagleader.manager.d.c.b("StartRowLine.ExcelXYSheetProperties"), new ab(this));
    a(com.flagleader.manager.d.c.b("StartCol.ExcelXYSheetProperties"), new aa(this));
    a(com.flagleader.manager.d.c.b("RowNameLine.ExcelXYSheetProperties"), new Y(this));
    a(com.flagleader.manager.d.c.b("RowAmountLine.ExcelXYSheetProperties"), new X(this));
    a(com.flagleader.manager.d.c.b("ChangedType.ExcelXYSheetProperties"), new S(this));
    a(com.flagleader.manager.d.c.b("EmptyType.ExcelXYSheetProperties"), new W(this));
  }

  private ExcelXYSheetModel f()
  {
    if ((d() != null) && ((d() instanceof ExcelXYSheetModel)))
      return (ExcelXYSheetModel)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.Q
 * JD-Core Version:    0.6.0
 */