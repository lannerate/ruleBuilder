package com.flagleader.builder.a.f;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

public class cZ
  implements FocusListener
{
  public cZ(cG paramcG)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    cG.a(this.a);
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
    cG.a(this.a);
    this.a.notifyObservers();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cZ
 * JD-Core Version:    0.6.0
 */