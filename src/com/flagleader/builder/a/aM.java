package com.flagleader.builder.a;

import com.flagleader.builder.widget.a.af;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

class aM extends FocusAdapter
{
  aM(aL paramaL)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    if (this.a.f.length() > 0)
      this.a.e.m().setText(this.a.f);
    this.a.setChanged();
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    if (this.a.e.m().getText().length() > 200000)
    {
      this.a.f = this.a.e.m().getText();
      this.a.e.m().setText(this.a.e.m().getText().substring(0, 20000));
    }
    this.a.a(this.a.e.m().getText());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aM
 * JD-Core Version:    0.6.0
 */