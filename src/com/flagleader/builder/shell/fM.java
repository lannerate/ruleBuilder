package com.flagleader.builder.shell;

import java.sql.Connection;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class fM extends ShellAdapter
{
  fM(fE paramfE)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    try
    {
      if ((fE.e(this.a) != null) && (!fE.e(this.a).isClosed()))
        fE.e(this.a).close();
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fM
 * JD-Core Version:    0.6.0
 */