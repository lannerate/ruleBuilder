package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;

class ci extends SelectionAdapter
{
  ci(ch paramch)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    super.widgetSelected(paramSelectionEvent);
    if (!ch.a(this.a).getText().equals(ch.b(this.a)))
    {
      ch.c(this.a).removeAll();
      ch.d(this.a);
      ch.a(this.a, ch.c(this.a).getItems(), ch.a(this.a).getSelectionIndex());
      ch.a(this.a, ch.a(this.a).getText());
      ch.a(this.a, ch.a(this.a).getSelectionIndex());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ci
 * JD-Core Version:    0.6.0
 */