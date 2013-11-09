package com.flagleader.builder.shell;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

class ej
  implements Listener
{
  ej(RuleThreadServerTray paramRuleThreadServerTray, Shell paramShell)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    this.b.setVisible(true);
    this.b.setMinimized(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ej
 * JD-Core Version:    0.6.0
 */