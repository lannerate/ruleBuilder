package com.flagleader.builder.e.h;

import com.flagleader.repository.IBusinessObjectContainer;
import java.util.ArrayList;
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
    if ((localTreeItem == null) || (localTreeItem.getData() == null))
      return;
    ArrayList localArrayList;
    if ((localTreeItem != null) && ((localTreeItem.getData() instanceof IBusinessObjectContainer)))
    {
      localArrayList = new ArrayList();
      for (int i = 0; i < localTreeItem.getItemCount(); i++)
      {
        localTreeItem.getItems()[i].setChecked(localTreeItem.getChecked());
        localArrayList.add(localTreeItem.getItem(i).getData());
      }
      if (localTreeItem.getChecked())
        this.a.a.d().a(localArrayList);
      else
        this.a.a.d().b(localArrayList);
    }
    else
    {
      localArrayList = new ArrayList();
      localArrayList.add(localTreeItem.getData());
      if (localTreeItem.getChecked())
        this.a.a.d().a(localArrayList);
      else
        this.a.a.d().b(localArrayList);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.h.b
 * JD-Core Version:    0.6.0
 */