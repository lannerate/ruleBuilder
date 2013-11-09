package com.flagleader.builder.b;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class l extends SelectionAdapter
{
  l(h paramh)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    int i = h.a(this.a).getSelectionIndex();
    if ((i > 0) && (h.a(this.a).getItemCount() > 1))
    {
      TableItem localTableItem = h.a(this.a).getItem(i - 1);
      String str = localTableItem.getText(0);
      localTableItem.setText(0, h.a(this.a).getItem(i).getText(0));
      h.a(this.a).getItem(i).setText(0, str);
      h.a(this.a).update();
      h.a(this.a).select(i - 1);
      h.a(this.a, true);
      this.a.a();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.b.l
 * JD-Core Version:    0.6.0
 */