package com.flagleader.builder.a.d;

import com.flagleader.repository.IElement;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class v extends SelectionAdapter
{
  v(o paramo)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if (localTreeItem != null)
    {
      if (o.c(this.a))
      {
        localTreeItem.setChecked(!localTreeItem.getChecked());
        return;
      }
      boolean bool = localTreeItem.getChecked();
      TreeItem[] arrayOfTreeItem = this.a.e.getSelection();
      if (arrayOfTreeItem.length > 0)
        for (int i = 0; i < arrayOfTreeItem.length; i++)
        {
          if (!this.a.a((IElement)arrayOfTreeItem[i].getData(), bool))
            continue;
          arrayOfTreeItem[i].setChecked(bool);
        }
      else if (!this.a.a((IElement)localTreeItem.getData(), localTreeItem.getChecked()))
        localTreeItem.setChecked(!localTreeItem.getChecked());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.v
 * JD-Core Version:    0.6.0
 */