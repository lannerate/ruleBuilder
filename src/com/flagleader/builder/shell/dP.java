package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

class dP
  implements SelectionListener
{
  dP(RuleServerTray paramRuleServerTray)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    RuleServerTray.c(this.a);
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dP
 * JD-Core Version:    0.6.0
 */