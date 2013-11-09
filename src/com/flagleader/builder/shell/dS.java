package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;

class dS
  implements SelectionListener
{
  dS(RuleServerTray paramRuleServerTray)
  {
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
    if ((RuleServerTray.b(this.a) != null) && (!RuleServerTray.b(this.a).b()))
    {
      RuleServerTray.b(this.a).a();
      RuleServerTray.a(this.a, null);
    }
    Display.getCurrent().close();
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    widgetDefaultSelected(paramSelectionEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dS
 * JD-Core Version:    0.6.0
 */