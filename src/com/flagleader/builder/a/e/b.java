package com.flagleader.builder.a.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class b extends MouseAdapter
{
  public b(a parama)
  {
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    a.a(this.a, a.d(this.a).getItem(localPoint));
    if (a.e(this.a) == null)
      return;
    if ((a.e(this.a).getData() != null) && ((a.e(this.a).getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)a.e(this.a).getData();
      a.a(this.a).getProjectTree().c(localITreeNode);
    }
    super.mouseDoubleClick(paramMouseEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.b
 * JD-Core Version:    0.6.0
 */