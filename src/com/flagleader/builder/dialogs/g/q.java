package com.flagleader.builder.dialogs.g;

import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class q extends SelectionAdapter
{
  q(p paramp)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if ((localTreeItem != null) && ((localTreeItem.getData() instanceof ITreeNode)))
    {
      if (!localTreeItem.getChecked())
        p.a(this.a, localTreeItem);
      p.a(this.a, localTreeItem.getItems(), localTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.q
 * JD-Core Version:    0.6.0
 */