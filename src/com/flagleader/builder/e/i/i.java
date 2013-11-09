package com.flagleader.builder.e.i;

import com.flagleader.repository.db.ISelectObject;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class i extends SelectionAdapter
{
  i(h paramh)
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
 * Qualified Name:     com.flagleader.builder.e.i.i
 * JD-Core Version:    0.6.0
 */