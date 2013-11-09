package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.tree.IRuleContainer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class aP extends SelectionAdapter
{
  aP(aK paramaK)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = aK.g(this.a).getSelectionIndex();
    if ((i > 0) && (aK.g(this.a).getItemCount() > 1))
    {
      TableItem localTableItem = aK.g(this.a).getItem(i - 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      Object localObject = localTableItem.getData();
      localTableItem.setText(new String[] { aK.g(this.a).getItem(i).getText(0), aK.g(this.a).getItem(i).getText(1), aK.g(this.a).getItem(i).getText(2) });
      localTableItem.setData(aK.g(this.a).getItem(i).getData());
      aK.g(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      aK.g(this.a).getItem(i).setData(localObject);
      aK.g(this.a).update();
      aK.g(this.a).setSelection(new int[] { i - 1 });
      aK.a(this.a).moveElement(i, i - 1);
      aK.a(this.a).getRoot().setModified(true);
      aK.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aP
 * JD-Core Version:    0.6.0
 */