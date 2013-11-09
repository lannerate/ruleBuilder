package com.flagleader.builder.a.g;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class p extends FocusAdapter
{
  p(o paramo, Text paramText, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((o.a(this.a) != null) && (!o.a(this.a).isDisposed()) && (this.b != null) && (!this.b.isDisposed()))
    {
      String str = this.b.getText();
      o.a(this.a).setText(this.c, str);
      o.a(this.a, str, this.c, o.a(this.a));
      this.b.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.p
 * JD-Core Version:    0.6.0
 */