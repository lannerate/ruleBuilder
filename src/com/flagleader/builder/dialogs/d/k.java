package com.flagleader.builder.dialogs.d;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class k extends SelectionAdapter
{
  k(a parama)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (a.d(this.a) != null)
    {
      n localn = new n(this.a, a.d(this.a).getText(0), a.d(this.a).getText(1), a.d(this.a).getText(2));
      if ((localn.open() == 0) && (localn.a().length() > 0))
      {
        StringBuffer localStringBuffer = new StringBuffer(localn.b());
        a.a(this.a, localStringBuffer);
        if ((!localn.a().equals(a.d(this.a).getText(0))) || (!localStringBuffer.toString().equals(a.d(this.a).getText(1))))
        {
          a.d(this.a).setText(0, localn.a());
          a.d(this.a).setText(1, localStringBuffer.toString());
          a.d(this.a).setText(2, localn.c());
          a.a(this.a, true);
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.d.k
 * JD-Core Version:    0.6.0
 */