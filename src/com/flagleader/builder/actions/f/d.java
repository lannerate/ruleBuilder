package com.flagleader.builder.actions.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.e.W;
import com.flagleader.repository.h;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class d
  implements Runnable
{
  d(c paramc, W paramW, String paramString)
  {
  }

  public void run()
  {
    if (this.b.i())
    {
      if (this.b.c().length() > 0)
      {
        c.a(this.a).showError(this.b.c());
      }
      else
      {
        c.a(this.a).getUserLogger().c(com.flagleader.manager.d.c.a("HasBeenExport", new String[] { this.c }));
        c.a(this.a).showSuccess(com.flagleader.manager.d.c.a("HasBeenExport", new String[] { this.c }));
      }
      c.a(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
    else
    {
      Display.getCurrent().timerExec(100, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f.d
 * JD-Core Version:    0.6.0
 */