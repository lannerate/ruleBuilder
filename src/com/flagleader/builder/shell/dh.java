package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.impl.SingleRuleEngineFactory;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class dh extends MouseAdapter
{
  private TreeItem b;

  dh(df paramdf)
  {
  }

  public void mouseDown(MouseEvent paramMouseEvent)
  {
    this.b = df.a(this.a).getItem(new Point(paramMouseEvent.x, paramMouseEvent.y));
    Object localObject;
    if ((this.b == null) && (paramMouseEvent.button == 3))
    {
      this.a.b = h.a();
      localObject = new MenuItem(this.a.b, 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("addlibrary.RuleServerTray", "add library"));
      ((MenuItem)localObject).addListener(13, new di(this));
      this.a.b.setEnabled(true);
      this.a.b.setVisible(true);
    }
    else if ((this.b != null) && (paramMouseEvent.button == 3))
    {
      this.a.b = h.a();
      localObject = df.a(this.a, this.b.getText());
      MenuItem localMenuItem = new MenuItem(this.a.b, 8);
      localMenuItem.setText(ResourceTools.getMessage("editlibrary.RuleServerTray", "edit library"));
      localMenuItem.addListener(13, new dj(this, (RuleEngineFactory)localObject));
      if ((localObject instanceof SingleRuleEngineFactory))
      {
        localMenuItem = new MenuItem(this.a.b, 8);
        localMenuItem.setText(ResourceTools.getMessage("readall.RuleServerTray", "read all rules"));
        localMenuItem.addListener(13, new dk(this, (RuleEngineFactory)localObject));
      }
      if (!this.b.getText().equals(ResourceTools.getMessage("actived.RuleServerTray")))
      {
        localMenuItem = new MenuItem(this.a.b, 8);
        localMenuItem.setText(ResourceTools.getMessage("activeproject.RuleServerTray", "active this"));
        localMenuItem.addListener(13, new dl(this));
        localMenuItem = new MenuItem(this.a.b, 8);
        localMenuItem.setText(ResourceTools.getMessage("deletelibrary.RuleServerTray", "delete library"));
        localMenuItem.addListener(13, new dm(this, (RuleEngineFactory)localObject));
      }
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
 * Qualified Name:     com.flagleader.builder.shell.dh
 * JD-Core Version:    0.6.0
 */