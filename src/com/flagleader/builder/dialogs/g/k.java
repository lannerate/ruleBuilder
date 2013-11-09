package com.flagleader.builder.dialogs.g;

import com.flagleader.repository.tree.IRuleProject;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class k extends SelectionAdapter
{
  k(j paramj)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i;
    List localList;
    TableItem localTableItem;
    if (j.a(this.a).getSelection())
    {
      j.b(this.a).removeAll();
      i = 0;
      do
      {
        localList = (List)j.c(this.a).get(i);
        localTableItem = new TableItem(j.b(this.a), 0);
        localTableItem.setData(localList);
        j.a(this.a, localTableItem, localList);
        i++;
        if (j.c(this.a) == null)
          break;
      }
      while (i < j.c(this.a).size());
    }
    else
    {
      j.b(this.a).removeAll();
      for (i = 0; (j.c(this.a) != null) && (i < j.c(this.a).size()); i++)
      {
        localList = (List)j.c(this.a).get(i);
        if (!localList.get(3).toString().equalsIgnoreCase(j.d(this.a).getDisplayName()))
          continue;
        localTableItem = new TableItem(j.b(this.a), 0);
        localTableItem.setData(localList);
        j.a(this.a, localTableItem, localList);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.k
 * JD-Core Version:    0.6.0
 */