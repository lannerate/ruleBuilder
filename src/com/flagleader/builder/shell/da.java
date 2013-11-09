package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class da extends SelectionAdapter
{
  da(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    RuleExecuteViewer.e(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.da
 * JD-Core Version:    0.6.0
 */