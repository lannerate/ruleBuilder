package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.engine.IRuleContext;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;

class dn extends MouseAdapter
{
  private TableItem b;

  dn(df paramdf)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    this.b = df.c(this.a).getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
    if ((this.b != null) && (paramMouseEvent.button == 3))
    {
      this.a.b = h.a();
      IRuleContext localIRuleContext = (IRuleContext)this.b.getData();
      MenuItem localMenuItem = new MenuItem(this.a.b, 8);
      localMenuItem.setText(ResourceTools.getMessage("testpack.RuleServerTray", "test"));
      localMenuItem.addListener(13, new do(this, localIRuleContext));
      this.a.b.setEnabled(true);
      this.a.b.setVisible(true);
    }
    else
    {
      df.a(this.a).setMenu(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dn
 * JD-Core Version:    0.6.0
 */