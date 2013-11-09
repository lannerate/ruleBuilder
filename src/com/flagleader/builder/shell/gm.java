package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class gm extends SelectionAdapter
{
  gm(TestRuleServerDialog paramTestRuleServerDialog)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    go localgo = new go(this.a);
    if ((localgo.open() == 0) && (localgo.a().length() > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(localgo.b());
      TableItem localTableItem = new TableItem(TestRuleServerDialog.c(this.a), 0);
      localTableItem.setText(new String[] { localgo.a(), localStringBuffer.toString() });
      TestRuleServerDialog.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.gm
 * JD-Core Version:    0.6.0
 */