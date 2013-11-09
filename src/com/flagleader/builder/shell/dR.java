package com.flagleader.builder.shell;

import com.flagleader.builder.dialogs.y;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

class dR
  implements SelectionListener
{
  dR(RuleServerTray paramRuleServerTray)
  {
  }

  public void widgetDefaultSelected(SelectionEvent paramSelectionEvent)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    y localy = new y(this.a);
    localy.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dR
 * JD-Core Version:    0.6.0
 */