package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class B extends SelectionAdapter
{
  B(MethodShell paramMethodShell, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    MethodShell.a(this.a, this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.B
 * JD-Core Version:    0.6.0
 */