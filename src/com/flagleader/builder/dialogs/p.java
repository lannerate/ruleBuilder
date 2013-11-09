package com.flagleader.builder.dialogs;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

class p extends SelectionAdapter
{
  p(o paramo)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.a.c.setEditable(((Button)paramSelectionEvent.widget).getSelection());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.p
 * JD-Core Version:    0.6.0
 */