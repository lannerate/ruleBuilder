package com.flagleader.builder.a.a;

import java.util.Vector;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;

class e
  implements Runnable
{
  e(a parama)
  {
  }

  public void run()
  {
    this.a.a(100);
    if ((!a.c(this.a).isEmpty()) || (!a.d(this.a)))
      this.a.e.getDisplay().timerExec(100, this);
    else
      this.a.e.getDisplay().timerExec(-1, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.e
 * JD-Core Version:    0.6.0
 */