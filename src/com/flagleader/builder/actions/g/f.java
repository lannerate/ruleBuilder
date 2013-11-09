package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.c;
import com.flagleader.manager.e.W;
import com.flagleader.repository.tree.RulePackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

class f
  implements Runnable
{
  f(d paramd, W paramW, RulePackage paramRulePackage)
  {
  }

  public void run()
  {
    if (this.b == null)
    {
      d.a(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
    if (this.b.i())
    {
      if (this.b.c().length() > 0)
        d.a(this.a).showError(this.b.c());
      else
        d.a(this.a).showSuccess(c.a("HasBeenExport", new String[] { this.c.getDisplayName() }));
      d.a(this.a).getShell().setCursor(null);
      Display.getCurrent().timerExec(-1, this);
    }
    else
    {
      Display.getCurrent().timerExec(100, this);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.f
 * JD-Core Version:    0.6.0
 */