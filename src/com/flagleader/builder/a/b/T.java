package com.flagleader.builder.a.b;

import com.flagleader.repository.excel.ExcelColModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.util.NumberUtil;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class T
  implements Listener
{
  T(S paramS, IBusinessObjectEditen paramIBusinessObjectEditen)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    y localy = this.a.G();
    if ((localy.open() == 0) && (localy.a().length() > 0))
    {
      ExcelColModel localExcelColModel = new ExcelColModel();
      localExcelColModel.setFieldPos(NumberUtil.parseInt(localy.a()));
      localExcelColModel.setValueType(localy.c());
      localExcelColModel.setDisplayName(localy.b());
      localExcelColModel.setVisible(true);
      this.b.addChildElement(localExcelColModel);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.T
 * JD-Core Version:    0.6.0
 */