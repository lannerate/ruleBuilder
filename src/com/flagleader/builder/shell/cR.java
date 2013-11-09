package com.flagleader.builder.shell;

import com.flagleader.server.RuleExecuteInfo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;

class cR
  implements Listener
{
  cR(cP paramcP, TableItem paramTableItem)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    if ((this.b.getData() instanceof RuleExecuteInfo))
      ((RuleExecuteInfo)this.b.getData()).forceStop();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cR
 * JD-Core Version:    0.6.0
 */