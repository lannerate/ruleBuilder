package com.flagleader.builder.widget;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class z
  implements Listener
{
  z(w paramw)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if (paramEvent.type != 11)
      return;
    this.a.layout(false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.z
 * JD-Core Version:    0.6.0
 */