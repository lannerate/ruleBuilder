package com.flagleader.builder.a;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Text;

class aD extends FocusAdapter
{
  aD(ax paramax, Text paramText, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    this.a.a(this.b.getText(), this.c);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aD
 * JD-Core Version:    0.6.0
 */