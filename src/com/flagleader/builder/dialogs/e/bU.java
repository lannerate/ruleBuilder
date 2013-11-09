package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetWhereEditen;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class bU extends SelectionAdapter
{
  bU(bS parambS)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = bS.e(this.a).getSelectionIndex();
    if ((i > -1) && (bS.e(this.a).getItemCount() > 1) && (i < bS.e(this.a).getItemCount() - 1))
    {
      TableItem localTableItem = bS.e(this.a).getItem(i + 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      String str4 = localTableItem.getText(3);
      Object localObject = localTableItem.getData();
      localTableItem.setText(new String[] { bS.e(this.a).getItem(i).getText(0), bS.e(this.a).getItem(i).getText(1), bS.e(this.a).getItem(i).getText(2), bS.e(this.a).getItem(i).getText(3) });
      localTableItem.setData(bS.e(this.a).getItem(i).getData());
      bS.e(this.a).getItem(i).setText(new String[] { str1, str2, str3, str4 });
      bS.e(this.a).getItem(i).setData(localObject);
      bS.e(this.a).update();
      bS.e(this.a).setSelection(new int[] { i + 1 });
      bS.c(this.a).moveElement(i, i + 1);
      bS.c(this.a).getRoot().setModified(true);
      bS.c(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bU
 * JD-Core Version:    0.6.0
 */