package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Tree;

class k extends SelectionAdapter
{
  k(h paramh, Button paramButton)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.b != null) && (!this.b.isDisposed()))
      h.a(this.a, h.a(this.a).getItems(), this.b.getSelection());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.k
 * JD-Core Version:    0.6.0
 */