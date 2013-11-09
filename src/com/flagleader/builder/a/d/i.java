package com.flagleader.builder.a.d;

import com.flagleader.builder.a.c.f;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class i extends FocusAdapter
{
  i(a parama, f paramf, TableItem paramTableItem)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (this.b.a(a.d(this.a).getText()))
      this.a.c(this.c);
    this.a.o();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.i
 * JD-Core Version:    0.6.0
 */