package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.d;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TreeItem;

class q extends FocusAdapter
{
  q(o paramo, d paramd, TreeItem paramTreeItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((o.e(this.a) != null) && (!o.e(this.a).isDisposed()) && (o.e(this.a).getSelectionIndex() >= 0))
    {
      if (this.b.a(o.e(this.a).getSelectionIndex()))
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
 * Qualified Name:     com.flagleader.builder.a.d.q
 * JD-Core Version:    0.6.0
 */