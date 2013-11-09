package com.flagleader.builder.a.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class f extends MouseAdapter
{
  public f(e parame)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    e.a(this.a, e.c(this.a).getItem(localPoint));
    if (e.d(this.a) == null)
      return;
    if (e.d(this.a) != e.e(this.a))
    {
      e.b(this.a, e.d(this.a));
      return;
    }
    if ((e.d(this.a).getData() != null) && ((e.d(this.a).getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)e.d(this.a).getData();
      e.a(this.a).getProjectTree().c(localITreeNode);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.f
 * JD-Core Version:    0.6.0
 */