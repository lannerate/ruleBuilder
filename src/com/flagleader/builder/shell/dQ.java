package com.flagleader.builder.shell;

import com.flagleader.server.RuleServer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

class dQ
  implements SelectionListener
{
  dQ(RuleServerTray paramRuleServerTray)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((RuleServerTray.b(this.a) != null) && (!RuleServerTray.b(this.a).b()))
    {
      RuleServerTray.b(this.a).a();
      RuleServerTray.a(this.a, null);
    }
    else
    {
      RuleServer.b();
      RuleServerTray.a(this.a, null);
    }
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dQ
 * JD-Core Version:    0.6.0
 */