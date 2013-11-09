package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class fv extends SelectionAdapter
{
  fv(SnapTraceViewer paramSnapTraceViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    SnapTraceViewer.c(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.fv
 * JD-Core Version:    0.6.0
 */