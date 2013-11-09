package com.flagleader.builder.a.b;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class K extends MouseAdapter
{
  private TreeItem b;
  private TreeItem c;

  private K(I paramI)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if ((I.a(this.a).getSelectionCount() >= 1) && (paramMouseEvent.button == 3))
    {
      if ((I.b(this.a) != null) && (!I.b(this.a).isDisposed()))
        I.b(this.a).dispose();
      I.a(this.a, h.a());
      MenuItem localMenuItem = new MenuItem(I.b(this.a), 8);
      localMenuItem.setText(ResourceTools.getMessage("copy.popup", "copy"));
      localMenuItem.addListener(13, new L(this));
      localMenuItem = new MenuItem(I.b(this.a), 8);
      localMenuItem.setText(ResourceTools.getMessage("update.popup", "update"));
      localMenuItem.addListener(13, new M(this));
      I.b(this.a).setEnabled(true);
      I.b(this.a).setVisible(true);
    }
    else
    {
      I.a(this.a).setMenu(null);
    }
    I.c(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.K
 * JD-Core Version:    0.6.0
 */