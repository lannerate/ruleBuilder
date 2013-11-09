package com.flagleader.builder.shell;

import com.flagleader.server.ExecuteInfos;
import com.flagleader.server.RuleExecuteInfo;
import java.util.List;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

class cL extends ShellAdapter
{
  cL(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void shellClosed(ShellEvent paramShellEvent)
  {
    RuleExecuteViewer.k(this.a);
    if (RuleExecuteViewer.l(this.a) != null)
    {
      List localList = RuleExecuteViewer.l(this.a).getInfos();
      for (int i = 0; i < localList.size(); i++)
        ((RuleExecuteInfo)localList.get(i)).setStoped(true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cL
 * JD-Core Version:    0.6.0
 */