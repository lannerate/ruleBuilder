package com.flagleader.builder.e.c;

import com.flagleader.repository.db.ISelectObject;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class b extends SelectionAdapter
{
  b(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if ((localTreeItem != null) && ((localTreeItem.getData() instanceof ISelectObject)))
    {
      TreeItem[] arrayOfTreeItem = localTreeItem.getItems();
      for (int i = 0; i < arrayOfTreeItem.length; i++)
        arrayOfTreeItem[i].setChecked(localTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.c.b
 * JD-Core Version:    0.6.0
 */