package com.flagleader.builder.e.b;

import com.flagleader.repository.db.ISelectObject;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class g extends SelectionAdapter
{
  g(f paramf)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableTreeItem localTableTreeItem = (TableTreeItem)paramSelectionEvent.item;
    if ((localTableTreeItem != null) && ((localTableTreeItem.getData() instanceof ISelectObject)))
    {
      TableTreeItem[] arrayOfTableTreeItem = localTableTreeItem.getItems();
      for (int i = 0; i < arrayOfTableTreeItem.length; i++)
        arrayOfTableTreeItem[i].setChecked(localTableTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.b.g
 * JD-Core Version:    0.6.0
 */