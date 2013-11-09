package com.flagleader.builder.a.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class l extends MouseAdapter
{
  l(k paramk)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    k.a(this.a, k.a(this.a).getItem(localPoint));
    if (k.b(this.a) == null)
      return;
    if ((k.b(this.a).getData() != null) && ((k.b(this.a).getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)k.b(this.a).getData();
      k.c(this.a).getProjectTree().c(localITreeNode);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.l
 * JD-Core Version:    0.6.0
 */