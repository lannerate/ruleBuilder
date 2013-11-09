package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class m extends SelectionAdapter
{
  m(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = a.c(this.a).getSelectionIndex();
    if ((i > 0) && (a.c(this.a).getItemCount() > 1))
    {
      TableItem localTableItem = a.c(this.a).getItem(i - 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      localTableItem.setText(new String[] { a.c(this.a).getItem(i).getText(0), a.c(this.a).getItem(i).getText(1), a.c(this.a).getItem(i).getText(2) });
      a.c(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      a.c(this.a).update();
      a.c(this.a).setSelection(new int[] { i - 1 });
      a.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.m
 * JD-Core Version:    0.6.0
 */