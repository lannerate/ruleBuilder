package com.flagleader.builder.a;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

class aF extends FocusAdapter
{
  aF(ax paramax, CCombo paramCCombo, int paramInt)
  {
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (this.b.getSelectionIndex() >= 0)
      this.a.a(this.b.getText(), this.c);
    else
      this.a.s();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aF
 * JD-Core Version:    0.6.0
 */