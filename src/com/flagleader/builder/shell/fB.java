package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class fB extends SelectionAdapter
{
  fB(SnapTraceViewer paramSnapTraceViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    SnapTraceViewer.b(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fB
 * JD-Core Version:    0.6.0
 */