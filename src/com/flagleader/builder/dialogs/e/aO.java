package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

class aO extends SelectionAdapter
{
  aO(aK paramaK)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (aK.g(this.a).getSelectionIndex() >= 0)
      this.a.f();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aO
 * JD-Core Version:    0.6.0
 */