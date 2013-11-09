package org.agilemore.agilegrid;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

class q
  implements Listener
{
  q(p paramp)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    Label localLabel = (Label)paramEvent.widget;
    Shell localShell = localLabel.getShell();
    switch (paramEvent.type)
    {
    case 3:
      Event localEvent = new Event();
      localEvent.item = p.a(this.a);
      localEvent.button = paramEvent.button;
      localEvent.stateMask = paramEvent.stateMask;
      p.a(this.a).notifyListeners(3, localEvent);
    }
    localShell.dispose();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.q
 * JD-Core Version:    0.6.0
 */