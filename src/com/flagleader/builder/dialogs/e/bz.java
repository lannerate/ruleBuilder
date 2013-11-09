package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bz extends SelectionAdapter
{
  bz(bx parambx)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String str = bx.c(this.a).getText();
    if ((str != null) && (str.length() > 0))
      for (int i = 0; i < be.b(bx.d(this.a)).length; i++)
      {
        if (!be.b(bx.d(this.a))[i].equalsIgnoreCase(str))
          continue;
        bx.b(this.a).select(i);
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bz
 * JD-Core Version:    0.6.0
 */