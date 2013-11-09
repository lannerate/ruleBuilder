package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class R extends SelectionAdapter
{
  R(M paramM)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    M.a(this.a, M.b(this.a).getSelectionIndex());
    M.b(this.a, M.c(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.R
 * JD-Core Version:    0.6.0
 */