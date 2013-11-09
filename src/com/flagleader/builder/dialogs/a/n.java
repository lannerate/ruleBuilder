package com.flagleader.builder.dialogs.a;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class n extends SelectionAdapter
{
  n(l paraml)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    l.b(this.a).setText(((TableItem)paramSelectionEvent.item).getText(0));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.a.n
 * JD-Core Version:    0.6.0
 */