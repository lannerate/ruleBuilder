package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.f;
import com.flagleader.manager.a.a.c;
import com.flagleader.manager.a.a.g;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class p extends x
{
  public p(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    List localList = f();
    if (localList != null)
    {
      Object localObject;
      for (int i = localList.size() - 1; i >= 0; i--)
      {
        if (this.a.getRulesManager().d() == null)
        {
          localObject = new RuleRepository();
          this.a.getRulesManager().a((IRuleRepository)localObject);
          b.a().a((RuleRepository)localObject);
        }
        if (this.a.getRulesManager().d().exitsDBPackage(((List)localList.get(i)).get(2).toString()) == null)
          continue;
        localList.remove(i);
      }
      f localf = new f(this.a.getShell(), localList);
      if (localf.open() == 0)
      {
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        localObject = localf.c();
        for (int j = 0; j < ((List)localObject).size(); j++)
        {
          if ((!(((List)localObject).get(j) instanceof List)) || (((List)((List)localObject).get(j)).size() <= 0))
            continue;
          try
          {
            g localg = this.a.getRulesManager().e();
            if (!localg.a(NumberUtil.getInt(StringUtil.stringValue(((List)((List)localObject).get(j)).get(0))), ((List)((List)localObject).get(j)).get(8).toString(), ((List)((List)localObject).get(j)).get(2).toString()))
              continue;
            RulePackage localRulePackage = localg.d();
            this.a.getRulesManager().b(localRulePackage, localg.a(), localg.h());
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            this.a.showError(localThrowable.getMessage());
          }
        }
        if (((List)localObject).size() > 0)
          this.a.getProjectTree().i();
        this.a.getShell().setCursor(null);
      }
    }
  }

  private List f()
  {
    try
    {
      c localc = this.a.getRulesManager().p();
      List localList = localc.a();
      if (localList == null)
      {
        MessageDialog.openError(this.a.getShell(), "", localc.i());
        return null;
      }
      return localList;
    }
    catch (Exception localException)
    {
    }
    return new ArrayList();
  }

  public String a()
  {
    return "OpenServerItem";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.p
 * JD-Core Version:    0.6.0
 */