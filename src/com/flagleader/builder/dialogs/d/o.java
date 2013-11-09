package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

class o extends SelectionAdapter
{
  o(n paramn)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = n.a(this.a).getSelectionIndex();
    if (i >= 0)
    {
      n.b(this.a).setText(a.b(n.d(this.a))[i]);
      n.c(this.a).setText("");
      n.b(this.a).setFocus();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.o
 * JD-Core Version:    0.6.0
 */