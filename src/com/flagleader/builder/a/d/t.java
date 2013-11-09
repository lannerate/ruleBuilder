package com.flagleader.builder.a.d;

import com.flagleader.repository.IElement;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class t
  implements MouseMoveListener
{
  t(o paramo)
  {
  }

  public void mouseMove(MouseEvent paramMouseEvent)
  {
    if ((paramMouseEvent.stateMask & 0x80000) != 0)
    {
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TreeItem localTreeItem = this.a.e.getItem(localPoint);
      if ((localTreeItem != null) && ((localTreeItem.getData() instanceof IElement)) && (o.b(this.a).equals(((IElement)localTreeItem.getData()).getParent())))
      {
        TreeItem[] arrayOfTreeItem1 = this.a.e.getSelection();
        for (int i = 0; i < arrayOfTreeItem1.length; i++)
          if (arrayOfTreeItem1[i].equals(localTreeItem))
            return;
        TreeItem[] arrayOfTreeItem2 = new TreeItem[arrayOfTreeItem1.length + 1];
        for (int j = 0; j < arrayOfTreeItem1.length; j++)
          arrayOfTreeItem2[j] = arrayOfTreeItem1[j];
        arrayOfTreeItem2[arrayOfTreeItem1.length] = localTreeItem;
        this.a.e.setSelection(arrayOfTreeItem2);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.t
 * JD-Core Version:    0.6.0
 */