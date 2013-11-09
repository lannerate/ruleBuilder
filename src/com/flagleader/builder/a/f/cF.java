package com.flagleader.builder.a.f;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

class cF extends FocusAdapter
{
  cF(cE paramcE)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    if (this.a.f.length() > 0)
      cE.a(this.a).setText(this.a.f);
    cE.b(this.a);
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (cE.a(this.a).getText().length() > 20000)
    {
      this.a.f = cE.a(this.a).getText();
      cE.a(this.a).setText(cE.a(this.a).getText().substring(0, 20000));
    }
    super.focusLost(paramFocusEvent);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cF
 * JD-Core Version:    0.6.0
 */