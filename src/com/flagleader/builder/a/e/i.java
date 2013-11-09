package com.flagleader.builder.a.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class i extends MouseAdapter
{
  public i(h paramh)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    h.a(this.a, h.c(this.a).getItem(localPoint));
    if (h.d(this.a) == null)
      return;
    if ((h.d(this.a).getData() != null) && ((h.d(this.a).getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)h.d(this.a).getData();
      h.a(this.a).getProjectTree().c(localITreeNode);
    }
    super.mouseDoubleClick(paramMouseEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.i
 * JD-Core Version:    0.6.0
 */