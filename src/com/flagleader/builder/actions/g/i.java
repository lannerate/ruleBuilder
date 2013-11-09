package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.h.o;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.e.W;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.Iterator;

public class i extends o
{
  public i(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof IRuleGroup));
  }

  protected boolean d()
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return;
    Object localObject;
    if ((this.a.getProjectTree().c() instanceof RulePackage))
    {
      localObject = this.a.getRulesManager().l().a((IRulePackage)paramITreeNode, ((IRulePackage)paramITreeNode).getCompilePath());
    }
    else if ((this.a.getProjectTree().c() instanceof IRuleGroup))
    {
      localObject = (IRuleGroup)this.a.getProjectTree().c();
      Iterator localIterator = ((IRuleGroup)localObject).getRulePackages();
      while (localIterator.hasNext())
      {
        IRulePackage localIRulePackage = (IRulePackage)localIterator.next();
        W localW = this.a.getRulesManager().l().a(localIRulePackage, localIRulePackage.getCompilePath());
      }
    }
  }

  public String a()
  {
    return "FtpExeRule";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.i
 * JD-Core Version:    0.6.0
 */