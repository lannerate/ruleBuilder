package com.flagleader.builder.dialogs.a;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class j extends SelectionAdapter
{
  j(i parami, Button paramButton)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.b != null) && (!this.b.isDisposed()))
    {
      TableItem[] arrayOfTableItem = i.a(this.a).getItems();
      for (int i = 0; (arrayOfTableItem != null) && (i < arrayOfTableItem.length); i++)
        arrayOfTableItem[i].setChecked(this.b.getSelection());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.j
 * JD-Core Version:    0.6.0
 */