package com.flagleader.builder.a.f;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class dv extends FocusAdapter
{
  dv(du paramdu, Text paramText, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((du.a(this.a) != null) && (!du.a(this.a).isDisposed()) && (this.b != null) && (!this.b.isDisposed()))
    {
      String str = this.b.getText();
      du.a(this.a).setText(this.c, str);
      du.a(this.a, str, this.c, du.a(this.a));
      this.b.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dv
 * JD-Core Version:    0.6.0
 */