package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.e;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TreeItem;

class y extends FocusAdapter
{
  y(o paramo, e parame, TreeItem paramTreeItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((o.e(this.a) != null) && (!o.e(this.a).isDisposed()) && (o.e(this.a).getSelectionIndex() >= 0))
    {
      if (this.b.a(o.e(this.a).getText()))
        this.a.c(this.c);
      this.a.o();
    }
    else
    {
      this.a.o();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.y
 * JD-Core Version:    0.6.0
 */