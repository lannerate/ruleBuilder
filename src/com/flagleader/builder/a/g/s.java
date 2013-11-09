package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.e.K;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class s
  implements Runnable
{
  s(r paramr)
  {
  }

  public void run()
  {
    if (!r.a(this.a).i())
    {
      this.a.e += 1;
      if (this.a.e < r.g(this.a) - 1)
        this.a.b(this.a.e);
      Display.getCurrent().timerExec(1000, this);
    }
    else
    {
      this.a.f();
      r.c(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.s
 * JD-Core Version:    0.6.0
 */