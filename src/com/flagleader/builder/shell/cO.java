package com.flagleader.builder.shell;

import com.flagleader.server.ExecuteInfos;
import com.flagleader.server.RuleExecuteInfo;
import com.flagleader.util.EngineLogger;
import java.util.List;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

class cO
  implements Runnable
{
  cO(RuleExecuteViewer paramRuleExecuteViewer)
  {
  }

  public void run()
  {
    Object localObject;
    int i;
    RuleExecuteInfo localRuleExecuteInfo1;
    if (RuleExecuteViewer.l(this.a) != null)
    {
      localObject = RuleExecuteViewer.l(this.a).getInfos();
      for (i = 0; i < ((List)localObject).size(); i++)
      {
        localRuleExecuteInfo1 = (RuleExecuteInfo)((List)localObject).get(i);
        if (!localRuleExecuteInfo1.isExceedTime())
          continue;
        EngineLogger.getSqlLogger().info("you need to stop rules " + localRuleExecuteInfo1.getDisplayName());
      }
    }
    RuleExecuteViewer.m(this.a);
    if ((RuleExecuteViewer.n(this.a)) && (RuleExecuteViewer.o(this.a) != null) && (!RuleExecuteViewer.o(this.a).isDisposed()))
    {
      localObject = RuleExecuteViewer.o(this.a).getItems();
      for (i = 0; i < localObject.length; i++)
      {
        localRuleExecuteInfo1 = localObject[i];
        RuleExecuteInfo localRuleExecuteInfo2 = (RuleExecuteInfo)localRuleExecuteInfo1.getData();
        RuleExecuteViewer.a(this.a, localRuleExecuteInfo1, localRuleExecuteInfo2);
      }
      RuleExecuteViewer.a(this.a, false);
    }
    RuleExecuteViewer.i(this.a).getDisplay().timerExec(1000, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.cO
 * JD-Core Version:    0.6.0
 */