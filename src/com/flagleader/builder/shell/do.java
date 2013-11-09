package com.flagleader.builder.shell;

import com.flagleader.engine.IRuleContext;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

class do
  implements Listener
{
  do(dn paramdn, IRuleContext paramIRuleContext)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    TestRuleServerDialog localTestRuleServerDialog = new TestRuleServerDialog(new Shell(), this.b, dn.a(this.a).getText(1));
    localTestRuleServerDialog.open();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.do
 * JD-Core Version:    0.6.0
 */