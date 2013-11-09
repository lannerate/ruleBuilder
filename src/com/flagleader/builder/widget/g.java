package com.flagleader.builder.widget;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Tree;

class g extends SelectionAdapter
{
  g(e parame, int paramInt)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    for (int i = 0; i < e.a(this.a).getItemCount(); i++)
      e.a(this.a, e.a(this.a).getItems()[i], this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.g
 * JD-Core Version:    0.6.0
 */