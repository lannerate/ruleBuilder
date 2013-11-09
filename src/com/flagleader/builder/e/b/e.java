package com.flagleader.builder.e.b;

import com.flagleader.repository.db.TableModel;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class e extends SelectionAdapter
{
  e(d paramd)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem localTableItem = (TableItem)paramSelectionEvent.item;
    if ((localTableItem != null) && ((localTableItem.getData() instanceof TableModel)))
      if (localTableItem.getChecked())
      {
        for (int i = 0; i < d.a(this.a).getItemCount(); i++)
        {
          if ((!d.a(this.a).getItem(i).getChecked()) || (d.a(this.a).getItem(i).equals(localTableItem)))
            continue;
          d.a(this.a).getItem(i).setChecked(false);
        }
        this.a.b.clear();
        this.a.a.c().a((TableModel)localTableItem.getData());
        this.a.b.add((TableModel)localTableItem.getData());
      }
      else
      {
        this.a.a.c().b((TableModel)localTableItem.getData());
        this.a.b.remove((TableModel)localTableItem.getData());
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.b.e
 * JD-Core Version:    0.6.0
 */