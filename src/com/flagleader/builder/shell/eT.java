package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class eT extends SelectionAdapter
{
  eT(RuleTraceViewer paramRuleTraceViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    RuleTraceViewer.c(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eT
 * JD-Core Version:    0.6.0
 */