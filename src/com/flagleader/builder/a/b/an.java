package com.flagleader.builder.a.b;

import java.util.List;
import org.eclipse.swt.widgets.Display;

class an
  implements Runnable
{
  an(aj paramaj)
  {
  }

  public void run()
  {
    while ((this.a.g.size() > 0) && (aj.d(this.a) != 2))
      try
      {
        aj.a(this.a, (Object[])this.a.g.remove(0));
      }
      catch (Exception localException)
      {
      }
    if ((aj.d(this.a) == 2) || ((aj.d(this.a) == 1) && (this.a.g.size() == 0)))
    {
      this.a.b(aj.e(this.a));
      Display.getCurrent().timerExec(-1, this);
    }
    else
    {
      Display.getCurrent().timerExec(100, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.an
 * JD-Core Version:    0.6.0
 */