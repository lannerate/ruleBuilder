package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class ao extends SelectionAdapter
{
  ao(an paraman)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String str = an.a(this.a).getText();
    if ((str != null) && (str.length() > 0))
      for (int i = 0; i < Y.b(an.c(this.a)).length; i++)
      {
        if (!Y.b(an.c(this.a))[i].equalsIgnoreCase(str))
          continue;
        an.b(this.a).select(i);
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ao
 * JD-Core Version:    0.6.0
 */