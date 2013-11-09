package com.flagleader.builder.shell;

import org.eclipse.swt.widgets.Display;

class et
  implements Runnable
{
  et(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void run()
  {
    RuleThreadServerTray.b(this.a);
    Display.getCurrent().timerExec(1000, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.et
 * JD-Core Version:    0.6.0
 */