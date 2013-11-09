package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.xml.TreeAttribute;
import com.flagleader.repository.xml.TreeValueNode;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class t extends SelectionAdapter
{
  t(s params)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if ((localTreeItem != null) && ((localTreeItem.getData() instanceof TreeValueNode)))
    {
      TreeItem[] arrayOfTreeItem = localTreeItem.getItems();
      for (int i = 0; i < arrayOfTreeItem.length; i++)
      {
        if (!(arrayOfTreeItem[i].getData() instanceof TreeAttribute))
          continue;
        arrayOfTreeItem[i].setChecked(localTreeItem.getChecked());
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.t
 * JD-Core Version:    0.6.0
 */