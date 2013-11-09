package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class gn extends SelectionAdapter
{
  gn(TestRuleServerDialog paramTestRuleServerDialog)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (TestRuleServerDialog.d(this.a) != null)
    {
      go localgo = new go(this.a, TestRuleServerDialog.d(this.a).getText(0), TestRuleServerDialog.d(this.a).getText(1), TestRuleServerDialog.d(this.a).getText(2));
      if ((localgo.open() == 0) && (localgo.a().length() > 0))
      {
        StringBuffer localStringBuffer = new StringBuffer(localgo.b());
        if ((!localgo.a().equals(TestRuleServerDialog.d(this.a).getText(0))) || (!localStringBuffer.toString().equals(TestRuleServerDialog.d(this.a).getText(1))))
        {
          TestRuleServerDialog.d(this.a).setText(0, localgo.a());
          TestRuleServerDialog.d(this.a).setText(1, localStringBuffer.toString());
          TestRuleServerDialog.a(this.a, true);
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.gn
 * JD-Core Version:    0.6.0
 */