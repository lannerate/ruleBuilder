package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class Q extends SelectionAdapter
{
  Q(M paramM)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = M.d(this.a).getSelectionIndex();
    if ((i > -1) && (M.d(this.a).getItemCount() > 1) && (i < M.d(this.a).getItemCount() - 1))
    {
      TableItem localTableItem = M.d(this.a).getItem(i + 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      localTableItem.setText(new String[] { M.d(this.a).getItem(i).getText(0), M.d(this.a).getItem(i).getText(1), M.d(this.a).getItem(i).getText(2) });
      M.d(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      M.d(this.a).update();
      M.d(this.a).setSelection(new int[] { i + 1 });
      M.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.Q
 * JD-Core Version:    0.6.0
 */