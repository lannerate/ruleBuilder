package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

class bQ extends SelectionAdapter
{
  bQ(bu parambu)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    bX localbX = new bX(this.a.j());
    localbX.b(new Shell().getDisplay());
    bu.a(this.a, localbX.g());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bQ
 * JD-Core Version:    0.6.0
 */