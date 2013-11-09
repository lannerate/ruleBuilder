package com.flagleader.builder.shell;

import com.flagleader.server.k;
import org.eclipse.swt.widgets.TableItem;

class eu
  implements Runnable
{
  eu(RuleThreadServerTray paramRuleThreadServerTray, int paramInt, k paramk)
  {
  }

  public void run()
  {
    TableItem localTableItem = new TableItem(this.a.h, 0);
    localTableItem.setText(0, this.b);
    RuleThreadServerTray.b(this.a, localTableItem, this.c);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.eu
 * JD-Core Version:    0.6.0
 */