package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class D extends SelectionAdapter
{
  D(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    MethodShell.f(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.D
 * JD-Core Version:    0.6.0
 */