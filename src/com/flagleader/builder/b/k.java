package com.flagleader.builder.b;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class k extends SelectionAdapter
{
  k(h paramh)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (h.a(this.a).getSelectionIndex() >= 0)
    {
      h.a(this.a).getSelection()[0].dispose();
      h.a(this.a, true);
      this.a.a();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.k
 * JD-Core Version:    0.6.0
 */