package com.flagleader.builder.dialogs;

import com.flagleader.repository.m;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class H extends SelectionAdapter
{
  H(z paramz)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (z.g(this.a).getSelection())
      m.a().c(1);
    else
      m.a().c(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.H
 * JD-Core Version:    0.6.0
 */