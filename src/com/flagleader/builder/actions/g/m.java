package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.e.W;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.Iterator;

public class m extends bl
{
  public m(BuilderManager paramBuilderManager)
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
    if (this.a.getProjectTree().c() == null)
      return;
    Object localObject;
    if ((this.a.getProjectTree().c() instanceof RulePackage))
    {
      localObject = this.a.getRulesManager().l().b((RulePackage)paramITreeNode);
    }
    else if ((this.a.getProjectTree().c() instanceof IRuleGroup))
    {
      localObject = (IRuleGroup)this.a.getProjectTree().c();
      Iterator localIterator = ((IRuleGroup)localObject).getRulePackages();
      while (localIterator.hasNext())
        W localW = this.a.getRulesManager().l().b((RulePackage)localIterator.next());
    }
  }

  public String a()
  {
    return "FtpRules";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.m
 * JD-Core Version:    0.6.0
 */