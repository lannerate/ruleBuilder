package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class br extends SelectionAdapter
{
  br(be parambe, Table paramTable1, Table paramTable2, Table paramTable3)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (be.j(this.a).getSelectionIndex() == 0)
      be.a(this.a, this.b);
    else if (be.j(this.a).getSelectionIndex() == 1)
      be.a(this.a, this.c);
    else if (be.j(this.a).getSelectionIndex() == 2)
      be.a(this.a, this.d);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.br
 * JD-Core Version:    0.6.0
 */