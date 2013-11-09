package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.e.U;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class dp
  implements Runnable
{
  dp(do paramdo)
  {
  }

  public void run()
  {
    if (!do.a(this.a).i())
    {
      this.a.e += 1;
      if (this.a.e < do.f(this.a) - 1)
        this.a.b(this.a.e);
      Display.getCurrent().timerExec(1000, this);
    }
    else
    {
      this.a.a(do.a(this.a).j(), do.a(this.a).k(), do.a(this.a).l());
      do.c(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dp
 * JD-Core Version:    0.6.0
 */