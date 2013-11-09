package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

class gg extends SelectionAdapter
{
  gg(TestRuleServerDialog paramTestRuleServerDialog)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    TestRuleServerDialog.a(this.a, TestRuleServerDialog.b(this.a).getSelectionIndex());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.gg
 * JD-Core Version:    0.6.0
 */