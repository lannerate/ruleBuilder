package com.flagleader.builder.shell;

import com.flagleader.server.k;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class es
  implements Runnable
{
  es(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void run()
  {
    if ((this.a.h.getItemCount() > 0) && (this.a.h != null) && (!this.a.h.isDisposed()))
      for (int i = this.a.h.getItemCount() - 1; i >= 0; i--)
      {
        TableItem localTableItem = this.a.h.getItem(i);
        k localk = (k)localTableItem.getData();
        if ((localk != null) && (localk.g() == 2))
          localTableItem.dispose();
        else
          RuleThreadServerTray.a(this.a, localTableItem, localk);
      }
    Display.getCurrent().timerExec(1000, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.es
 * JD-Core Version:    0.6.0
 */