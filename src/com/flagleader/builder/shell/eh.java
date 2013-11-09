package com.flagleader.builder.shell;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class eh extends SelectionAdapter
{
  eh(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a.a.getSelectionIndex() == 1)
      RuleThreadServerTray.a(this.a);
    else
      this.a.a.getSelectionIndex();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eh
 * JD-Core Version:    0.6.0
 */