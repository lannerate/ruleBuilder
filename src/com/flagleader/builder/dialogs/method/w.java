package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class w extends SelectionAdapter
{
  w(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (MethodShell.l(this.a) == null)
      return;
    TableItem localTableItem = new TableItem(MethodShell.c(this.a), 0);
    localTableItem.setText(MethodShell.l(this.a));
    MethodShell.a(this.a, true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.w
 * JD-Core Version:    0.6.0
 */