package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class M extends SelectionAdapter
{
  M(C paramC, Table paramTable1, Table paramTable2)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.a.getSelectionIndex() == 0)
      C.a(this.a, this.b);
    else if (this.a.a.getSelectionIndex() == 1)
      C.a(this.a, this.c);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.M
 * JD-Core Version:    0.6.0
 */