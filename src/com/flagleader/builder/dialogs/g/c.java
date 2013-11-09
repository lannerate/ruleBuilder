package com.flagleader.builder.dialogs.g;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class c extends SelectionAdapter
{
  c(b paramb)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (b.a(this.a) > 1)
    {
      b tmp15_12 = this.a;
      b.a(tmp15_12, b.a(tmp15_12) - 1);
    }
    b.b(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.c
 * JD-Core Version:    0.6.0
 */