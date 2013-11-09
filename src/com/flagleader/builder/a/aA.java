package com.flagleader.builder.a;

import com.flagleader.repository.IElement;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;

class aA
  implements MouseMoveListener
{
  aA(ax paramax)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.stateMask & 0x80000) != 0)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableTreeItem localTableTreeItem = ax.a(this.a).getItem(localPoint);
      if ((localTableTreeItem != null) && ((localTableTreeItem.getData() instanceof IElement)) && (this.a.c.equals(((IElement)localTableTreeItem.getData()).getParent())))
      {
        TableTreeItem[] arrayOfTableTreeItem1 = ax.a(this.a).getSelection();
        for (int i = 0; i < arrayOfTableTreeItem1.length; i++)
          if (arrayOfTableTreeItem1[i].equals(localTableTreeItem))
            return;
        TableTreeItem[] arrayOfTableTreeItem2 = new TableTreeItem[arrayOfTableTreeItem1.length + 1];
        for (int j = 0; j < arrayOfTableTreeItem1.length; j++)
          arrayOfTableTreeItem2[j] = arrayOfTableTreeItem1[j];
        arrayOfTableTreeItem2[arrayOfTableTreeItem1.length] = localTableTreeItem;
        ax.a(this.a).setSelection(arrayOfTableTreeItem2);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aA
 * JD-Core Version:    0.6.0
 */