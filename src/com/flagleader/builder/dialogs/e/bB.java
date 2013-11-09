package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bB extends SelectionAdapter
{
  bB(bA parambA)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    for (int i = 0; i < bA.a(this.a).getItemCount(); i++)
    {
      if (bA.a(this.a).getItem(i).equals(paramSelectionEvent.item))
        continue;
      bA.a(this.a).getItem(i).setChecked(false);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bB
 * JD-Core Version:    0.6.0
 */