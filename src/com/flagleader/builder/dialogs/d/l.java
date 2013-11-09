package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class l extends SelectionAdapter
{
  l(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (a.c(this.a).getSelectionIndex() >= 0)
      this.a.m();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.l
 * JD-Core Version:    0.6.0
 */