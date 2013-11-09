package com.flagleader.builder.a.a;

import java.util.List;
import org.eclipse.swt.widgets.Display;

class Q
  implements Runnable
{
  Q(M paramM)
  {
  }

  public void run()
  {
    while ((this.a.g.size() > 0) && (M.g(this.a) != 2))
      M.a(this.a, (Object[])this.a.g.remove(0));
    if ((M.g(this.a) == 2) || ((M.g(this.a) == 1) && (this.a.g.size() == 0)))
    {
      this.a.b(M.h(this.a));
      Display.getCurrent().timerExec(-1, this);
    }
    else
    {
      Display.getCurrent().timerExec(100, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.Q
 * JD-Core Version:    0.6.0
 */