package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class eS extends SelectionAdapter
{
  eS(RuleTraceViewer paramRuleTraceViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    RuleTraceViewer.b(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eS
 * JD-Core Version:    0.6.0
 */