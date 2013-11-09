package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class O extends SelectionAdapter
{
  O(M paramM)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (M.d(this.a).getSelectionIndex() >= 0)
      this.a.h();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.O
 * JD-Core Version:    0.6.0
 */