package com.flagleader.builder.dialogs.e;

import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class I extends SelectionAdapter
{
  I(C paramC)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = C.f(this.a).getSelectionIndex();
    if ((i > 0) && (C.f(this.a).getItemCount() > 1))
    {
      TableItem localTableItem = C.f(this.a).getItem(i - 1);
      String str1 = localTableItem.getText(0);
      String str2 = localTableItem.getText(1);
      String str3 = localTableItem.getText(2);
      Object localObject = localTableItem.getData();
      localTableItem.setText(new String[] { C.f(this.a).getItem(i).getText(0), C.f(this.a).getItem(i).getText(1), C.f(this.a).getItem(i).getText(2) });
      localTableItem.setData(C.f(this.a).getItem(i).getData());
      C.f(this.a).getItem(i).setText(new String[] { str1, str2, str3 });
      C.f(this.a).getItem(i).setData(localObject);
      C.f(this.a).update();
      C.f(this.a).setSelection(new int[] { i - 1 });
      C.a(this.a).moveElement(i, i - 1);
      C.a(this.a).setModified(true);
      C.a(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.I
 * JD-Core Version:    0.6.0
 */