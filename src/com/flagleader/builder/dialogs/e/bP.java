package com.flagleader.builder.dialogs.e;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bP extends SelectionAdapter
{
  bP(bE parambE)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = bE.e(this.a).getSelectionIndex();
    if ((i > 0) && (bE.e(this.a).getItemCount() > 1))
    {
      TableItem localTableItem = bE.e(this.a).getItem(i - 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      Object localObject = localTableItem.getData();
      localTableItem.setText(new String[] { bE.e(this.a).getItem(i).getText(0), bE.e(this.a).getItem(i).getText(1), bE.e(this.a).getItem(i).getText(2) });
      localTableItem.setData(bE.e(this.a).getItem(i).getData());
      bE.e(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      bE.e(this.a).getItem(i).setData(localObject);
      bE.e(this.a).update();
      bE.e(this.a).setSelection(new int[] { i - 1 });
      bE.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bP
 * JD-Core Version:    0.6.0
 */