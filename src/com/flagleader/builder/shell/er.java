package com.flagleader.builder.shell;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

class er
  implements Listener
{
  er(RuleThreadServerTray paramRuleThreadServerTray, Menu paramMenu, Shell paramShell)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    this.b.setVisible(true);
    if (this.c.isVisible())
    {
      this.b.getItem(0).setEnabled(true);
      this.b.getItem(1).setEnabled(true);
    }
    else
    {
      this.b.getItem(0).setEnabled(true);
      this.b.getItem(1).setEnabled(false);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.er
 * JD-Core Version:    0.6.0
 */