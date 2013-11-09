package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

class y extends SelectionAdapter
{
  y(w paramw)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    w.a(this.a, ((Button)paramSelectionEvent.widget).getSelection());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.y
 * JD-Core Version:    0.6.0
 */