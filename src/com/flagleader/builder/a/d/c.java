package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.d;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;

class c extends FocusAdapter
{
  c(a parama, d paramd, TableItem paramTableItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (a.e(this.a).getSelectionIndex() >= 0)
    {
      if (this.b.a(a.e(this.a).getSelectionIndex()))
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
 * Qualified Name:     com.flagleader.builder.a.d.c
 * JD-Core Version:    0.6.0
 */