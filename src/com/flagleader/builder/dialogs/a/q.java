package com.flagleader.builder.dialogs.a;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
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
    if ((localTreeItem != null) && (localTreeItem.getChecked()) && ((localTreeItem.getData() instanceof IBusinessObjectContainer)))
    {
      TreeItem[] arrayOfTreeItem = localTreeItem.getItems();
      for (int i = 0; i < arrayOfTreeItem.length; i++)
        arrayOfTreeItem[i].setChecked(localTreeItem.getChecked());
    }
    if ((localTreeItem != null) && (!localTreeItem.getChecked()) && ((localTreeItem.getData() instanceof IBusinessObjectEditen)))
      localTreeItem.getParentItem().setChecked(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.q
 * JD-Core Version:    0.6.0
 */