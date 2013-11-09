package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.c;
import com.flagleader.manager.e.W;
import com.flagleader.repository.tree.RulePackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class l
  implements Runnable
{
  l(k paramk, W paramW, RulePackage paramRulePackage)
  {
  }

  public void run()
  {
    if (this.b == null)
    {
      k.a(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
    if (this.b.i())
    {
      if (this.b.c().length() > 0)
        k.a(this.a).showError(this.b.c());
      else
        k.a(this.a).showSuccess(c.a("HasBeenExport", new String[] { this.c.getDisplayName() }));
      k.a(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
    else
    {
      Display.getCurrent().timerExec(100, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.l
 * JD-Core Version:    0.6.0
 */