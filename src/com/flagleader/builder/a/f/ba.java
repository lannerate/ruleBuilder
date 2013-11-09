package com.flagleader.builder.a.f;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

public class ba
  implements FocusListener
{
  public ba(aX paramaX)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    aX.a(this.a);
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    aX.a(this.a);
    this.a.notifyObservers();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.ba
 * JD-Core Version:    0.6.0
 */