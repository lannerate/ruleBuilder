package com.flagleader.builder.shell;

import com.flagleader.server.RuleThreadServer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

class en
  implements SelectionListener
{
  en(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((RuleThreadServerTray.d(this.a) != null) && (!RuleThreadServerTray.d(this.a).b()))
    {
      RuleThreadServerTray.d(this.a).a();
      RuleThreadServerTray.a(this.a, null);
    }
    else
    {
      RuleThreadServer.b();
      RuleThreadServerTray.a(this.a, null);
    }
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.en
 * JD-Core Version:    0.6.0
 */