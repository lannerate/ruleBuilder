package com.flagleader.builder.shell;

import org.eclipse.swt.widgets.Display;

class dM
  implements Runnable
{
  dM(RuleServerTray paramRuleServerTray)
  {
  }

  public void run()
  {
    RuleServerTray.a(this.a);
    Display.getCurrent().timerExec(1000, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dM
 * JD-Core Version:    0.6.0
 */