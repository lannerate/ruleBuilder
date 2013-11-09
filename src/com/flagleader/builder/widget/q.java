package com.flagleader.builder.widget;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

class q extends FocusAdapter
{
  q(p paramp)
  {
  }

  public void focusGained(FocusEvent paramFocusEvent)
  {
    p.a(this.a);
    this.a.notifyObservers();
  }

  public void focusLost(FocusEvent paramFocusEvent)
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.q
 * JD-Core Version:    0.6.0
 */