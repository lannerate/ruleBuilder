package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class j extends SelectionAdapter
{
  j(h paramh)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if (localTreeItem != null)
    {
      if (!localTreeItem.getChecked())
        h.a(this.a, localTreeItem);
      h.a(this.a, localTreeItem.getItems(), localTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.j
 * JD-Core Version:    0.6.0
 */