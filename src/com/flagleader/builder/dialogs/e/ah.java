package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ah
  implements MouseMoveListener
{
  ah(Y paramY)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.stateMask & 0x80000) != 0)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = Y.h(this.a).getItem(localPoint);
      if (localTableItem != null)
      {
        TableItem[] arrayOfTableItem1 = Y.h(this.a).getSelection();
        for (int i = 0; i < arrayOfTableItem1.length; i++)
          if (arrayOfTableItem1[i].equals(localTableItem))
            return;
        TableItem[] arrayOfTableItem2 = new TableItem[arrayOfTableItem1.length + 1];
        for (int j = 0; j < arrayOfTableItem1.length; j++)
          arrayOfTableItem2[j] = arrayOfTableItem1[j];
        arrayOfTableItem2[arrayOfTableItem1.length] = localTableItem;
        Y.h(this.a).setSelection(arrayOfTableItem2);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ah
 * JD-Core Version:    0.6.0
 */