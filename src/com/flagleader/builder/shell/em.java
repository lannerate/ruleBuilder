package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

class em
  implements SelectionListener
{
  em(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    RuleThreadServerTray.e(this.a);
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.em
 * JD-Core Version:    0.6.0
 */