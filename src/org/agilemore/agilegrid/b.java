package org.agilemore.agilegrid;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class b
  implements Listener
{
  b(a parama, e parame)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    switch (paramEvent.type)
    {
    case 1:
      this.a.c = this.b.A();
      this.a.a(this.a.c);
      break;
    case 3:
    case 5:
    case 7:
    case 8:
    case 12:
    case 13:
    case 32:
      this.a.c = this.b.o(paramEvent.x, paramEvent.y);
      this.a.a(this.a.c);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.b
 * JD-Core Version:    0.6.0
 */