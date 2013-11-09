package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bv extends SelectionAdapter
{
  bv(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String str = bu.a(this.a).getText();
    if ((str != null) && (str.length() > 0))
      for (int i = 0; i < be.b(bu.c(this.a)).length; i++)
      {
        if (!be.b(bu.c(this.a))[i].equalsIgnoreCase(str))
          continue;
        bu.b(this.a).select(i);
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bv
 * JD-Core Version:    0.6.0
 */