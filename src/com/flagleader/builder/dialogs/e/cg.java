package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;

class cg extends SelectionAdapter
{
  cg(cf paramcf)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    super.widgetSelected(paramSelectionEvent);
    if (!cf.a(this.a).getText().equals(cf.b(this.a)))
    {
      cf.c(this.a).removeAll();
      cf.d(this.a);
      cf.a(this.a, cf.c(this.a).getItems(), cf.a(this.a).getSelectionIndex());
      cf.a(this.a, cf.a(this.a).getText());
      cf.a(this.a, cf.a(this.a).getSelectionIndex());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.cg
 * JD-Core Version:    0.6.0
 */