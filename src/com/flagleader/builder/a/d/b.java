package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.c;
import com.flagleader.builder.a.c.e;
import com.flagleader.repository.IElement;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

class b extends SelectionAdapter
{
  b(a parama, TableColumn paramTableColumn, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.a.f() > 1) && (paramSelectionEvent.widget != null) && (paramSelectionEvent.widget.equals(this.b)))
    {
      TableItem localTableItem = this.a.e.getSelection()[0];
      if ((localTableItem.getData() != null) && ((localTableItem.getData() instanceof IElement)))
      {
        c localc = this.a.a((IElement)localTableItem.getData(), this.c, true);
        if ((localc != null) && ((localc instanceof e)))
          a.a(this.a, localTableItem, this.c, (e)localc);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.b
 * JD-Core Version:    0.6.0
 */