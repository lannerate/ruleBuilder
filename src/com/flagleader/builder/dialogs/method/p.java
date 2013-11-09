package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class p extends SelectionAdapter
{
  p(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    MethodShell.m(this.a).a(false);
    MethodShell.m(this.a).b(false);
    MethodShell.m(this.a).c(true);
    MethodShell.m(this.a).c("");
    MethodShell.m(this.a).a(0);
    MethodShell.m(this.a).h();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.p
 * JD-Core Version:    0.6.0
 */