package com.flagleader.builder.dialogs;

import com.flagleader.repository.m;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class I extends SelectionAdapter
{
  I(z paramz)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (z.h(this.a).getSelection())
      m.a().b(1);
    else
      m.a().b(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.I
 * JD-Core Version:    0.6.0
 */