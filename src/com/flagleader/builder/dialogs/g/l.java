package com.flagleader.builder.dialogs.g;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class l extends SelectionAdapter
{
  l(j paramj, Button paramButton)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.b != null) && (!this.b.isDisposed()))
    {
      TableItem[] arrayOfTableItem = j.b(this.a).getItems();
      for (int i = 0; (arrayOfTableItem != null) && (i < arrayOfTableItem.length); i++)
        arrayOfTableItem[i].setChecked(this.b.getSelection());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.l
 * JD-Core Version:    0.6.0
 */