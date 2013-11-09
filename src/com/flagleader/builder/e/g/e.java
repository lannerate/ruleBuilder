package com.flagleader.builder.e.g;

import com.flagleader.repository.IBusinessObjectContainer;
import java.util.ArrayList;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class e extends SelectionAdapter
{
  e(c paramc)
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
        this.a.a.d().c(localArrayList);
      else
        this.a.a.d().d(localArrayList);
    }
    else
    {
      localArrayList = new ArrayList();
      localArrayList.add(localTreeItem.getData());
      if (localTreeItem.getChecked())
        this.a.a.d().c(localArrayList);
      else
        this.a.a.d().d(localArrayList);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.g.e
 * JD-Core Version:    0.6.0
 */