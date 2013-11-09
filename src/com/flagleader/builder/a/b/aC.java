package com.flagleader.builder.a.b;

import com.flagleader.builder.BuilderManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class aC
  implements Runnable
{
  aC(aB paramaB)
  {
  }

  public void run()
  {
    if (!aB.a(this.a).b())
    {
      this.a.e += 1;
      if (this.a.e < aB.g(this.a) - 1)
        this.a.b(this.a.e);
      Display.getCurrent().timerExec(1000, this);
    }
    else
    {
      this.a.a(aB.a(this.a).a());
      aB.c(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b.aC
 * JD-Core Version:    0.6.0
 */