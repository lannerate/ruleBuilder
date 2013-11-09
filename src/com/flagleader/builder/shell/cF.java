package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class cF extends SelectionAdapter
{
  cF(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    RuleExecuteViewer.c(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cF
 * JD-Core Version:    0.6.0
 */