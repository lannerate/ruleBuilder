package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bD extends SelectionAdapter
{
  bD(bC parambC)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (paramSelectionEvent.detail == 32)
      for (int i = 0; i < bC.a(this.a).getSelectionCount(); i++)
      {
        if (bC.a(this.a).getSelection()[i].equals(paramSelectionEvent.item))
          continue;
        bC.a(this.a).getSelection()[i].setChecked(((TableItem)paramSelectionEvent.item).getChecked());
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bD
 * JD-Core Version:    0.6.0
 */