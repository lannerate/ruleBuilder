package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class F extends SelectionAdapter
{
  F(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (MethodShell.a(this.a))
      MethodShell.g(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.F
 * JD-Core Version:    0.6.0
 */