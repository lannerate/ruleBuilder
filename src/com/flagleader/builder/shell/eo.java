package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.L;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

class eo
  implements SelectionListener
{
  eo(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    L localL = new L(this.a);
    localL.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eo
 * JD-Core Version:    0.6.0
 */