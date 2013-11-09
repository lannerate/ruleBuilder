package com.flagleader.builder.a.e;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class t
  implements Listener
{
  t(s params)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    s.a(this.a).a((paramEvent.stateMask & SWT.MOD1) != 0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e.t
 * JD-Core Version:    0.6.0
 */