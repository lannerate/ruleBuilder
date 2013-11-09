package com.flagleader.builder.shell;

import com.flagleader.server.RuleExecuteInfo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;

class cQ
  implements Listener
{
  cQ(cP paramcP, TableItem paramTableItem)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    RuleExecuteInfo localRuleExecuteInfo = (RuleExecuteInfo)this.b.getData();
    localRuleExecuteInfo.setRunOnce(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cQ
 * JD-Core Version:    0.6.0
 */