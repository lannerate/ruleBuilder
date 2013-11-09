package com.flagleader.builder.dialogs.b;

import com.flagleader.repository.rom.IBOAndContainer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class y extends SelectionAdapter
{
  y(w paramw)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if ((localTreeItem != null) && ((localTreeItem.getData() instanceof IBOAndContainer)))
    {
      TreeItem[] arrayOfTreeItem = localTreeItem.getItems();
      for (int i = 0; i < arrayOfTreeItem.length; i++)
        arrayOfTreeItem[i].setChecked(localTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.y
 * JD-Core Version:    0.6.0
 */