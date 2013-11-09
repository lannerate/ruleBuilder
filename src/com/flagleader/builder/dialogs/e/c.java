package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.xml.TreeValueNode;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class c extends SelectionAdapter
{
  c(b paramb)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TreeItem localTreeItem = (TreeItem)paramSelectionEvent.item;
    if ((localTreeItem != null) && ((localTreeItem.getData() instanceof TreeValueNode)))
      b.a(this.a, localTreeItem.getItems(), localTreeItem.getChecked());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.c
 * JD-Core Version:    0.6.0
 */