package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;

class ep
  implements SelectionListener
{
  ep(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
    if ((RuleThreadServerTray.d(this.a) != null) && (!RuleThreadServerTray.d(this.a).b()))
    {
      RuleThreadServerTray.d(this.a).a();
      RuleThreadServerTray.a(this.a, null);
    }
    Display.getCurrent().close();
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    widgetDefaultSelected(paramSelectionEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ep
 * JD-Core Version:    0.6.0
 */