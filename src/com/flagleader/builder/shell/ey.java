package com.flagleader.builder.shell;

import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class ey
  implements ShellListener
{
  ey(RuleThreadServerTray paramRuleThreadServerTray, Shell paramShell)
  {
  }

  public void shellDeactivated(ShellEvent paramShellEvent)
  {
  }

  public void shellActivated(ShellEvent paramShellEvent)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    if ((RuleThreadServerTray.d(this.a) != null) && (!RuleThreadServerTray.d(this.a).b()))
    {
      RuleThreadServerTray.d(this.a).a();
      RuleThreadServerTray.a(this.a, null);
    }
    if (!Display.getCurrent().isDisposed())
      Display.getCurrent().close();
  }

  public void shellDeiconified(ShellEvent paramShellEvent)
  {
  }

  public void shellIconified(ShellEvent paramShellEvent)
  {
    this.b.setVisible(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ey
 * JD-Core Version:    0.6.0
 */