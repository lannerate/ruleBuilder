package com.flagleader.builder.dialogs;

import com.flagleader.repository.m;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class J extends SelectionAdapter
{
  J(z paramz)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (z.i(this.a).getSelection())
      m.a().a(1);
    else
      m.a().a(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.J
 * JD-Core Version:    0.6.0
 */