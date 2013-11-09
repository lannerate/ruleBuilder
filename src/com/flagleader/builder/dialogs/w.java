package com.flagleader.builder.dialogs;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;

class w extends SelectionAdapter
{
  w(u paramu, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    for (int i = 0; i < u.a(this.a).getItemCount(); i++)
      u.a(this.a, u.a(this.a).getItems()[i], this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.w
 * JD-Core Version:    0.6.0
 */