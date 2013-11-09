package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.e.N;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class b
  implements Runnable
{
  b(a parama)
  {
  }

  public void run()
  {
    if (!a.a(this.a).i())
    {
      this.a.e += 1;
      if (this.a.e < a.h(this.a) - 1)
        this.a.b(this.a.e);
      Display.getCurrent().timerExec(1000, this);
    }
    else
    {
      this.a.f();
      a.c(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.b
 * JD-Core Version:    0.6.0
 */