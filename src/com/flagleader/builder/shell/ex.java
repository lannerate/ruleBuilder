package com.flagleader.builder.shell;

import com.flagleader.engine.Property;
import com.flagleader.server.RuleThreadInfo;
import java.util.Date;
import java.util.Stack;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class ex
  implements Runnable
{
  ex(RuleThreadServerTray paramRuleThreadServerTray)
  {
  }

  public void run()
  {
    while (!RuleThreadServerTray.c(this.a).isEmpty())
    {
      RuleThreadInfo localRuleThreadInfo = (RuleThreadInfo)RuleThreadServerTray.c(this.a).pop();
      for (int i = 0; i < this.a.g.getItemCount(); i++)
      {
        if (!this.a.g.getItems()[i].getText(0).equals(localRuleThreadInfo.getRuleName()))
          continue;
        this.a.g.getItems()[i].setText(1, Property.getInstance().formatDatetime(new Date()));
        this.a.g.getItems()[i].setText(3, localRuleThreadInfo.getReceives().size());
        return;
      }
      TableItem localTableItem = new TableItem(this.a.g, 0);
      localTableItem.setText(0, localRuleThreadInfo.getRuleName());
      localTableItem.setText(1, Property.getInstance().formatDatetime(new Date()));
      localTableItem.setText(2, localRuleThreadInfo.getMinThreads() + "-" + localRuleThreadInfo.getMaxThreads());
      localTableItem.setText(3, localRuleThreadInfo.getReceives().size());
      localTableItem.setText(4, localRuleThreadInfo.getRemoteips());
    }
    Display.getCurrent().timerExec(1000, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.ex
 * JD-Core Version:    0.6.0
 */