package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class aG extends SelectionAdapter
{
  aG(aF paramaF)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String str = aF.a(this.a).getText();
    if ((str != null) && (str.length() > 0))
      for (int i = 0; i < as.b(aF.c(this.a)).length; i++)
      {
        if (!as.b(aF.c(this.a))[i].equalsIgnoreCase(str))
          continue;
        aF.b(this.a).select(i);
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aG
 * JD-Core Version:    0.6.0
 */