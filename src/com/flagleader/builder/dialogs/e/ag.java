package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class ag extends SelectionAdapter
{
  ag(Y paramY, Table paramTable1, Table paramTable2)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (Y.g(this.a).getSelectionIndex() == 0)
      Y.a(this.a, this.b);
    else if (Y.g(this.a).getSelectionIndex() == 1)
      Y.a(this.a, this.c);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ag
 * JD-Core Version:    0.6.0
 */