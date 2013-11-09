package com.flagleader.builder.shell;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class Y extends SelectionAdapter
{
  Y(M paramM)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (M.e(this.a) != null)
    {
      Z localZ = new Z(this.a, M.e(this.a).getText(0), M.e(this.a).getText(1), M.e(this.a).getText(2));
      if ((localZ.open() == 0) && (localZ.a().length() > 0))
      {
        StringBuffer localStringBuffer = new StringBuffer(localZ.b());
        if ((!localZ.a().equals(M.e(this.a).getText(0))) || (!localStringBuffer.toString().equals(M.e(this.a).getText(1))))
        {
          M.e(this.a).setText(0, localZ.a());
          M.e(this.a).setText(1, localStringBuffer.toString());
          M.a(this.a, true);
        }
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.Y
 * JD-Core Version:    0.6.0
 */