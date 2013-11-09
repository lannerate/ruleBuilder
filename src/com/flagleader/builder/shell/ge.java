package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ge extends SelectionAdapter
{
  ge(TestRuleServerDialog paramTestRuleServerDialog)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = TestRuleServerDialog.c(this.a).getSelectionIndex();
    if ((i > 0) && (TestRuleServerDialog.c(this.a).getItemCount() > 1))
    {
      TableItem localTableItem = TestRuleServerDialog.c(this.a).getItem(i - 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      localTableItem.setText(new String[] { TestRuleServerDialog.c(this.a).getItem(i).getText(0), TestRuleServerDialog.c(this.a).getItem(i).getText(1), TestRuleServerDialog.c(this.a).getItem(i).getText(2) });
      TestRuleServerDialog.c(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      TestRuleServerDialog.c(this.a).update();
      TestRuleServerDialog.c(this.a).setSelection(new int[] { i - 1 });
      TestRuleServerDialog.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ge
 * JD-Core Version:    0.6.0
 */