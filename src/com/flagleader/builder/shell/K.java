package com.flagleader.builder.shell;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class K extends ShellAdapter
{
  K(J paramJ)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    if (this.a.b != null)
      this.a.b.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.K
 * JD-Core Version:    0.6.0
 */