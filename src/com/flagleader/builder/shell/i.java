package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class i extends SelectionAdapter
{
  i(g paramg, TreeItem paramTreeItem)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    ClassInfoEditor.b(g.a(this.a), this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.i
 * JD-Core Version:    0.6.0
 */