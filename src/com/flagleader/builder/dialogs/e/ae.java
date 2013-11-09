package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ae extends SelectionAdapter
{
  ae(Y paramY)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = Y.h(this.a).getSelectionIndex();
    if ((i > -1) && (Y.h(this.a).getItemCount() > 1) && (i < Y.h(this.a).getItemCount() - 1))
    {
      TableItem localTableItem = Y.h(this.a).getItem(i + 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      Object localObject = localTableItem.getData();
      localTableItem.setText(new String[] { Y.h(this.a).getItem(i).getText(0), Y.h(this.a).getItem(i).getText(1), Y.h(this.a).getItem(i).getText(2) });
      localTableItem.setData(Y.h(this.a).getItem(i).getData());
      Y.h(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      Y.h(this.a).getItem(i).setData(localObject);
      Y.h(this.a).update();
      Y.h(this.a).setSelection(new int[] { i + 1 });
      Y.a(this.a).moveElement(i, i + 1);
      Y.a(this.a).getRoot().setModified(true);
      Y.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.ae
 * JD-Core Version:    0.6.0
 */