package com.flagleader.builder.a.d;

import com.flagleader.repository.IElement;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class h extends SelectionAdapter
{
  h(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem localTableItem = (TableItem)paramSelectionEvent.item;
    if (localTableItem != null)
    {
      if (a.c(this.a))
      {
        localTableItem.setChecked(!localTableItem.getChecked());
        return;
      }
      boolean bool = localTableItem.getChecked();
      TableItem[] arrayOfTableItem = this.a.e.getSelection();
      if (arrayOfTableItem.length > 0)
        for (int i = 0; i < arrayOfTableItem.length; i++)
        {
          if (!this.a.a((IElement)arrayOfTableItem[i].getData(), bool))
            continue;
          arrayOfTableItem[i].setChecked(bool);
        }
      else if (!this.a.a((IElement)localTableItem.getData(), localTableItem.getChecked()))
        localTableItem.setChecked(!localTableItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.h
 * JD-Core Version:    0.6.0
 */