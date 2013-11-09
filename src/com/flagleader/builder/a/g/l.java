package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.e.K;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class l
  implements Runnable
{
  l(k paramk)
  {
  }

  public void run()
  {
    if (!k.a(this.a).i())
    {
      this.a.e += 1;
      if (this.a.e < k.f(this.a) - 1)
        this.a.b(this.a.e);
      Display.getCurrent().timerExec(1000, this);
    }
    else
    {
      this.a.f();
      k.e(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.l
 * JD-Core Version:    0.6.0
 */