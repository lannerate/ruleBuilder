package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class f extends ShellAdapter
{
  f(MethodShell paramMethodShell)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    paramShellEvent.doit = MethodShell.a(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.f
 * JD-Core Version:    0.6.0
 */