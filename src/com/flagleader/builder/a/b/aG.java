package com.flagleader.builder.a.b;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class aG extends FocusAdapter
{
  aG(aF paramaF, Text paramText, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if ((aF.a(this.a) != null) && (!aF.a(this.a).isDisposed()) && (this.b != null) && (!this.b.isDisposed()))
    {
      String str = this.b.getText();
      aF.a(this.a).setText(this.c, str);
      aF.a(this.a, str, this.c, aF.a(this.a));
      this.b.dispose();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aG
 * JD-Core Version:    0.6.0
 */