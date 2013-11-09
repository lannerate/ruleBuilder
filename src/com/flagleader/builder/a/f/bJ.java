package com.flagleader.builder.a.f;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

public class bJ
  implements FocusListener
{
  public bJ(bu parambu)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    bu.a(this.a);
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    bu.a(this.a);
    this.a.notifyObservers();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bJ
 * JD-Core Version:    0.6.0
 */