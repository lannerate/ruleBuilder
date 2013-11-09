package com.flagleader.builder.a.b;

import com.flagleader.repository.d.u;
import com.flagleader.repository.excel.ExcelCellModel;
import com.flagleader.repository.excel.ExcelFunction;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class P
  implements Listener
{
  P(N paramN, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Q localQ = new Q(this.a);
    if (localQ.open() == 0)
    {
      String str = "";
      if ((localQ.a() > 0) && (localQ.b() > 0))
        str = u.a("setCellColor.excel", new Object[] { this.b.getDisplayName(), com.flagleader.repository.excel.ExcelSheetModel.COLORTYPES[localQ.a()], com.flagleader.repository.excel.ExcelSheetModel.COLORTYPES[localQ.b()] });
      else if (localQ.b() > 0)
        str = u.a("setCellBackcolor.excel", new Object[] { this.b.getDisplayName(), com.flagleader.repository.excel.ExcelSheetModel.COLORTYPES[localQ.b()] });
      else if (localQ.a() > 0)
        str = u.a("setCellForcolor.excel", new Object[] { this.b.getDisplayName(), com.flagleader.repository.excel.ExcelSheetModel.COLORTYPES[localQ.a()] });
      ExcelFunction localExcelFunction = new ExcelFunction("setCellColor", "void", "setCellColor(" + ((ExcelCellModel)this.b).getFieldPos() + "," + localQ.a() + "," + localQ.b() + ")", str, null, true, "p");
      this.b.addChildElement(localExcelFunction);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.P
 * JD-Core Version:    0.6.0
 */