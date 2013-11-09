package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class dc extends SelectionAdapter
{
  dc(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    RuleExecuteViewer.g(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dc
 * JD-Core Version:    0.6.0
 */