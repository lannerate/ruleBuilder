package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TreeItem;

class h extends SelectionAdapter
{
  h(g paramg, TreeItem paramTreeItem)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    ClassInfoEditor.a(g.a(this.a), this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.h
 * JD-Core Version:    0.6.0
 */