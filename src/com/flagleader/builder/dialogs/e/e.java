package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.tree.ITreeNode;
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
    if ((localTreeItem != null) && ((localTreeItem.getData() instanceof ITreeNode)))
    {
      if (!localTreeItem.getChecked())
        d.a(this.a, localTreeItem);
      d.a(this.a, localTreeItem.getItems(), localTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.e
 * JD-Core Version:    0.6.0
 */