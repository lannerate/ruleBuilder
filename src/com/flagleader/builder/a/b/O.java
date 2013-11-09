package com.flagleader.builder.a.b;

import com.flagleader.repository.excel.ExcelCellModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.util.NumberUtil;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class O
  implements Listener
{
  O(N paramN, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    y localy = this.a.G();
    if ((localy.open() == 0) && (localy.a().length() > 0))
    {
      ExcelCellModel localExcelCellModel = new ExcelCellModel();
      localExcelCellModel.setFieldPos(NumberUtil.parseInt(localy.a()));
      localExcelCellModel.setValueType(localy.c());
      localExcelCellModel.setDisplayName(localy.b());
      localExcelCellModel.setVisible(true);
      this.b.addChildElement(localExcelCellModel);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.O
 * JD-Core Version:    0.6.0
 */