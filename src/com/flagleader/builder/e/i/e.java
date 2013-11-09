package com.flagleader.builder.e.i;

import com.flagleader.repository.db.ISelectObject;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class e extends SelectionAdapter
{
  e(d paramd)
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
 * Qualified Name:     com.flagleader.builder.e.i.e
 * JD-Core Version:    0.6.0
 */