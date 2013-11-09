package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class cP extends MouseAdapter
{
  cP(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      if ((RuleExecuteViewer.p(this.a) != null) && (!RuleExecuteViewer.p(this.a).isDisposed()))
        RuleExecuteViewer.p(this.a).dispose();
      RuleExecuteViewer.a(this.a, new Menu(RuleExecuteViewer.q(this.a).getShell(), 8));
      Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
      TableItem localTableItem = RuleExecuteViewer.o(this.a).getItem(localPoint);
      if (localTableItem != null)
      {
        int i = -1;
        for (int j = 1; j < RuleExecuteViewer.o(this.a).getColumnCount() + 1; j++)
        {
          if (!localTableItem.getBounds(j).contains(localPoint))
            continue;
          i = j;
        }
        if (i > 0)
        {
          j = i;
          MenuItem localMenuItem = new MenuItem(RuleExecuteViewer.p(this.a), 8);
          localMenuItem.setText(ResourceTools.getMessage("runonce.RuleExecuteViewer", "runonce"));
          localMenuItem.addListener(13, new cQ(this, localTableItem));
          localMenuItem = new MenuItem(RuleExecuteViewer.p(this.a), 8);
          localMenuItem.setText(ResourceTools.getMessage("forcestrop.popup", "force stop"));
          localMenuItem.addListener(13, new cR(this, localTableItem));
        }
      }
      RuleExecuteViewer.p(this.a).setEnabled(true);
      RuleExecuteViewer.p(this.a).setVisible(true);
    }
  }

  public void mouseDoubleClick(MouseEvent paramMouseEvent)
  {
    Point localPoint = new Point(paramMouseEvent.x, paramMouseEvent.y);
    TableItem localTableItem = RuleExecuteViewer.o(this.a).getItem(localPoint);
    if (localTableItem == null)
      return;
    RuleExecuteViewer.e(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cP
 * JD-Core Version:    0.6.0
 */