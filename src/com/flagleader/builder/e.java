package com.flagleader.builder;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class e extends ShellAdapter
{
  e(BuilderManager paramBuilderManager)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    this.a.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e
 * JD-Core Version:    0.6.0
 */