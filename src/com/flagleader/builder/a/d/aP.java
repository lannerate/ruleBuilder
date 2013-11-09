package com.flagleader.builder.a.d;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

class aP extends SelectionAdapter
{
  aP(aO paramaO)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = aO.a(this.a).getSelectionIndex();
    if (i >= 0)
    {
      aO.b(this.a).setText(aO.c(this.a)[i]);
      aO.d(this.a).setText("");
      aO.b(this.a).setFocus();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aP
 * JD-Core Version:    0.6.0
 */