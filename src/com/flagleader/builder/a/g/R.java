package com.flagleader.builder.a.g;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class R extends FocusAdapter
{
  R(Q paramQ, Text paramText, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((Q.a(this.a) != null) && (!Q.a(this.a).isDisposed()) && (this.b != null) && (!this.b.isDisposed()))
    {
      String str = this.b.getText();
      Q.a(this.a).setText(this.c, str);
      Q.a(this.a, str, this.c, Q.a(this.a));
      this.b.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.R
 * JD-Core Version:    0.6.0
 */