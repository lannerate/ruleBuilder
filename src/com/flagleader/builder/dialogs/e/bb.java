package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class bb extends SelectionAdapter
{
  bb(aZ paramaZ, String[] paramArrayOfString)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    String str = aZ.b(this.a).getText();
    if ((str != null) && (str.length() > 0))
      for (int i = 0; i < this.b.length; i++)
      {
        if (!this.b[i].equalsIgnoreCase(str))
          continue;
        aZ.a(this.a).select(i);
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bb
 * JD-Core Version:    0.6.0
 */