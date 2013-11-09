package com.flagleader.builder.dialogs.g;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class z extends SelectionAdapter
{
  z(y paramy, Button paramButton)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.b != null) && (!this.b.isDisposed()))
    {
      TableItem[] arrayOfTableItem = y.a(this.a).getItems();
      for (int i = 0; (arrayOfTableItem != null) && (i < arrayOfTableItem.length); i++)
        arrayOfTableItem[i].setChecked(this.b.getSelection());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.z
 * JD-Core Version:    0.6.0
 */