package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class n extends SelectionAdapter
{
  n(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem[] arrayOfTableItem = MethodShell.c(this.a).getSelection();
    if (arrayOfTableItem.length == 0)
      return;
    arrayOfTableItem[0].dispose();
    MethodShell.a(this.a, true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.n
 * JD-Core Version:    0.6.0
 */