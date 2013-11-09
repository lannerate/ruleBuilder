package com.flagleader.builder.shell;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class cM extends SelectionAdapter
{
  cM(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (RuleExecuteViewer.i(this.a).getSelectionIndex() == 1)
      RuleExecuteViewer.j(this.a);
    else if (RuleExecuteViewer.i(this.a).getSelectionIndex() == 2)
      RuleExecuteViewer.g(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cM
 * JD-Core Version:    0.6.0
 */