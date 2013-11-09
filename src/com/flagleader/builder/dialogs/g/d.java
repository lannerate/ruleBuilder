package com.flagleader.builder.dialogs.g;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class d extends SelectionAdapter
{
  d(b paramb)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    b tmp4_1 = this.a;
    b.a(tmp4_1, b.a(tmp4_1) + 1);
    b.b(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.d
 * JD-Core Version:    0.6.0
 */