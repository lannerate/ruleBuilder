package com.flagleader.builder.e.e;

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
    this.a.b.clear();
    TableItem localTableItem = (TableItem)paramSelectionEvent.item;
    for (int i = d.a(this.a).getSelection().length - 1; i >= 0; i--)
    {
      if (d.a(this.a).getSelection()[i].equals(localTableItem))
        continue;
      d.a(this.a).getSelection()[i].setChecked(false);
    }
    if ((localTableItem != null) && ((localTableItem.getData() instanceof TableModel)))
      if (localTableItem.getChecked())
      {
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
 * Qualified Name:     com.flagleader.builder.e.e.e
 * JD-Core Version:    0.6.0
 */