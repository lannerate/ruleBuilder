package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class j extends SelectionAdapter
{
  j(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    n localn = new n(this.a);
    if ((localn.open() == 0) && (localn.a().length() > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(localn.b());
      a.a(this.a, localStringBuffer);
      TableItem localTableItem = new TableItem(a.c(this.a), 0);
      localTableItem.setText(new String[] { localn.a(), localStringBuffer.toString(), localn.c() });
      a.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.j
 * JD-Core Version:    0.6.0
 */