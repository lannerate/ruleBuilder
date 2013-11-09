package com.flagleader.builder.dialogs.method;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class l extends SelectionAdapter
{
  l(MethodShell paramMethodShell)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem[] arrayOfTableItem = MethodShell.c(this.a).getSelection();
    if (arrayOfTableItem.length == 0)
      return;
    MethodShell.a(this.a, new String[MethodShell.c(this.a).getColumnCount()]);
    for (int i = 0; i < MethodShell.l(this.a).length; i++)
      MethodShell.l(this.a)[i] = arrayOfTableItem[0].getText(i);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.method.l
 * JD-Core Version:    0.6.0
 */