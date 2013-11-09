package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class X extends SelectionAdapter
{
  X(M paramM)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    Z localZ = new Z(this.a);
    if ((localZ.open() == 0) && (localZ.a().length() > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer(localZ.b());
      TableItem localTableItem = new TableItem(M.d(this.a), 0);
      localTableItem.setText(new String[] { localZ.a(), localStringBuffer.toString() });
      M.a(this.a, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.X
 * JD-Core Version:    0.6.0
 */