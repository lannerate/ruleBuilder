package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class ay extends SelectionAdapter
{
  ay(as paramas, Table paramTable1, Table paramTable2, Table paramTable3)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.a.getSelectionIndex() == 0)
      as.a(this.a, this.b);
    else if (this.a.a.getSelectionIndex() == 1)
      as.a(this.a, this.c);
    else if (this.a.a.getSelectionIndex() == 2)
      as.a(this.a, this.d);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ay
 * JD-Core Version:    0.6.0
 */