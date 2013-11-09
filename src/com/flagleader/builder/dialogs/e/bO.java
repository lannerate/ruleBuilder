package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class bO extends SelectionAdapter
{
  bO(bE parambE)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (bE.e(this.a).getSelectionIndex() >= 0)
      this.a.f();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bO
 * JD-Core Version:    0.6.0
 */