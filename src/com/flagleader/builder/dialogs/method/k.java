package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class k extends SelectionAdapter
{
  k(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem[] arrayOfTableItem = MethodShell.c(this.a).getSelection();
    if (arrayOfTableItem.length == 0)
      return;
    MethodShell.a(this.a, arrayOfTableItem[0]);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.k
 * JD-Core Version:    0.6.0
 */