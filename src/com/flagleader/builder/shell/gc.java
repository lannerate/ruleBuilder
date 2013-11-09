package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class gc extends SelectionAdapter
{
  gc(TestRuleServerDialog paramTestRuleServerDialog)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TestRuleServerDialog.a(this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.gc
 * JD-Core Version:    0.6.0
 */