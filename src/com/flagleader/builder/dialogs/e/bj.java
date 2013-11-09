package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bj extends SelectionAdapter
{
  bj(be parambe)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = be.k(this.a).getSelectionIndex();
    if ((i > 0) && (be.k(this.a).getItemCount() > 1))
    {
      TableItem localTableItem = be.k(this.a).getItem(i - 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      Object localObject = localTableItem.getData();
      localTableItem.setText(new String[] { be.k(this.a).getItem(i).getText(0), be.k(this.a).getItem(i).getText(1), be.k(this.a).getItem(i).getText(2) });
      localTableItem.setData(be.k(this.a).getItem(i).getData());
      be.k(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      be.k(this.a).getItem(i).setData(localObject);
      be.k(this.a).update();
      be.k(this.a).setSelection(new int[] { i - 1 });
      be.a(this.a).moveElement(i, i - 1);
      be.a(this.a).getRoot().setModified(true);
      be.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bj
 * JD-Core Version:    0.6.0
 */