package com.flagleader.builder.shell;

import java.io.File;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

class cV
  implements DisposeListener
{
  public void widgetDisposed(DisposeEvent paramDisposeEvent)
  {
    if (new File("execute.lck").exists())
      new File("execute.lck").delete();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cV
 * JD-Core Version:    0.6.0
 */