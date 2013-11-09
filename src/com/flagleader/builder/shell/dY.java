package com.flagleader.builder.shell;

import java.util.Vector;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class dY
  implements Runnable
{
  dY(RuleServerTray paramRuleServerTray)
  {
  }

  public void run()
  {
    if ((this.a.i.size() > 0) && (this.a.g.getItemCount() > 0) && (this.a.g != null) && (!this.a.g.isDisposed()))
      for (int i = this.a.g.getItemCount() - 1; i >= 0; i--)
      {
        TableItem localTableItem = this.a.g.getItem(i);
        for (int j = this.a.i.size() - 1; j >= 0; j--)
        {
          if (!((String)this.a.i.get(j)).equals(localTableItem.getText(0)))
            continue;
          this.a.i.remove(j);
          localTableItem.dispose();
          break;
        }
      }
    Display.getCurrent().timerExec(1000, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.dY
 * JD-Core Version:    0.6.0
 */