package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class ba extends SelectionAdapter
{
  ba(aZ paramaZ)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String str = aZ.a(this.a).getText();
    if ((str != null) && (str.length() > 0))
      for (int i = 0; i < aK.b(aZ.c(this.a)).length; i++)
      {
        if (!aK.b(aZ.c(this.a))[i].equalsIgnoreCase(str))
          continue;
        aZ.b(this.a).select(i);
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ba
 * JD-Core Version:    0.6.0
 */