package com.flagleader.builder.dialogs.a;

import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class h extends MouseAdapter
{
  h(g paramg)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = g.a(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    int i = -1;
    for (int j = 1; j < g.a(this.a).getColumnCount() + 1; j++)
    {
      if (!localTableItem.getBounds(j).contains(localPoint))
        continue;
      i = j;
    }
    IBusinessObject localIBusinessObject = (IBusinessObject)localTableItem.getData();
    if ((localIBusinessObject instanceof IFunctionObject))
    {
      r localr = new r((IFunctionObject)localIBusinessObject);
      if (localr.open() == 0)
      {
        g.a(this.a, localTableItem, localIBusinessObject, true);
        ((IFunctionObject)localIBusinessObject).changeParams();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.h
 * JD-Core Version:    0.6.0
 */