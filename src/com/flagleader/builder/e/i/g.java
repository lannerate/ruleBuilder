package com.flagleader.builder.e.i;

import com.flagleader.repository.db.TableModel;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class g extends SelectionAdapter
{
  g(f paramf)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TableItem localTableItem = (TableItem)paramSelectionEvent.item;
    if ((localTableItem != null) && ((localTableItem.getData() instanceof TableModel)))
      if (localTableItem.getChecked())
      {
        this.a.a.c().a((TableModel)localTableItem.getData());
        this.a.a.d().a((TableModel)localTableItem.getData());
        this.a.b.add((TableModel)localTableItem.getData());
      }
      else
      {
        this.a.a.c().b((TableModel)localTableItem.getData());
        this.a.a.d().b((TableModel)localTableItem.getData());
        this.a.b.remove((TableModel)localTableItem.getData());
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.i.g
 * JD-Core Version:    0.6.0
 */