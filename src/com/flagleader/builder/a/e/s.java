package com.flagleader.builder.a.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.tree.IRuleTree;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class s extends MouseAdapter
{
  private TreeItem b;
  private TreeItem c;

  private s(q paramq)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if ((q.a(this.a).getSelectionCount() >= 1) && (paramMouseEvent.button == 3))
    {
      if ((q.b(this.a) != null) && (!q.b(this.a).isDisposed()))
        q.b(this.a).dispose();
      q.a(this.a, h.a());
      MenuItem localMenuItem = new MenuItem(q.b(this.a), 8);
      localMenuItem.setText(ResourceTools.getMessage("copy.popup", "copy"));
      localMenuItem.addListener(13, new t(this));
      if ((this.a.f() instanceof IRuleTree))
      {
        localMenuItem = new MenuItem(q.b(this.a), 8);
        localMenuItem.setText(ResourceTools.getMessage("copybom.popup", "copy"));
        localMenuItem.addListener(13, new u(this));
      }
      localMenuItem = new MenuItem(q.b(this.a), 8);
      localMenuItem.setText(ResourceTools.getMessage("update.popup", "update"));
      localMenuItem.addListener(13, new v(this));
      q.b(this.a).setEnabled(true);
      q.b(this.a).setVisible(true);
    }
    else
    {
      q.a(this.a).setMenu(null);
    }
    q.c(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.s
 * JD-Core Version:    0.6.0
 */