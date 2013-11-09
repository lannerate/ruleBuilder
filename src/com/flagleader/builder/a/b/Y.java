package com.flagleader.builder.a.b;

import com.flagleader.repository.excel.ExcelRowModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.util.NumberUtil;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class Y
  implements Listener
{
  Y(X paramX, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    y localy = this.a.G();
    if ((localy.open() == 0) && (localy.a().length() > 0))
    {
      ExcelRowModel localExcelRowModel = new ExcelRowModel();
      localExcelRowModel.setFieldPos(NumberUtil.parseInt(localy.a()));
      localExcelRowModel.setValueType(localy.c());
      localExcelRowModel.setDisplayName(localy.b());
      localExcelRowModel.setVisible(true);
      this.b.addChildElement(localExcelRowModel);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.Y
 * JD-Core Version:    0.6.0
 */