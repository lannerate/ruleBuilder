package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;

class el
  implements SelectionListener
{
  el(RuleThreadServerTray paramRuleThreadServerTray, Shell paramShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.b.setMinimized(true);
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.el
 * JD-Core Version:    0.6.0
 */