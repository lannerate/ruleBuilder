package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Shell;

class J extends ShellAdapter
{
  J(I paramI)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    paramShellEvent.doit = false;
    this.a.a.setVisible(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.J
 * JD-Core Version:    0.6.0
 */