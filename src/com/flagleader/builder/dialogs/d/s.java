package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class s extends SelectionAdapter
{
  s(r paramr)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if ((localTreeItem != null) && (localTreeItem.getData() == null))
    {
      TreeItem[] arrayOfTreeItem = localTreeItem.getItems();
      for (int i = 0; i < arrayOfTreeItem.length; i++)
        arrayOfTreeItem[i].setChecked(localTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.s
 * JD-Core Version:    0.6.0
 */