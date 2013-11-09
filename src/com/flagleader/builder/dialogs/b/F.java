package com.flagleader.builder.dialogs.b;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class F extends SelectionAdapter
{
  F(C paramC)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (paramSelectionEvent.detail == 32)
      for (int i = 0; i < C.c(this.a).getSelectionCount(); i++)
      {
        if (C.c(this.a).getSelection()[i].equals(paramSelectionEvent.item))
          continue;
        C.c(this.a).getSelection()[i].setChecked(((TableItem)paramSelectionEvent.item).getChecked());
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.b.F
 * JD-Core Version:    0.6.0
 */