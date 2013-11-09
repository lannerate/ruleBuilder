package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aw extends SelectionAdapter
{
  aw(as paramas)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = as.f(this.a).getSelectionIndex();
    if ((i > -1) && (as.f(this.a).getItemCount() > 1) && (i < as.f(this.a).getItemCount() - 1))
    {
      TableItem localTableItem = as.f(this.a).getItem(i + 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      Object localObject = localTableItem.getData();
      localTableItem.setText(new String[] { as.f(this.a).getItem(i).getText(0), as.f(this.a).getItem(i).getText(1), as.f(this.a).getItem(i).getText(2) });
      localTableItem.setData(as.f(this.a).getItem(i).getData());
      as.f(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      as.f(this.a).getItem(i).setData(localObject);
      as.f(this.a).update();
      as.f(this.a).setSelection(new int[] { i + 1 });
      as.a(this.a).moveElement(i, i + 1);
      as.a(this.a).getRoot().setModified(true);
      as.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aw
 * JD-Core Version:    0.6.0
 */