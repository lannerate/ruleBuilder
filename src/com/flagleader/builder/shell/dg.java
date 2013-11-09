package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class dg extends SelectionAdapter
{
  dg(df paramdf)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    df.a(this.a, (TreeItem)paramSelectionEvent.item);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dg
 * JD-Core Version:    0.6.0
 */