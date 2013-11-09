package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.StringUtil;
import java.util.Iterator;

public class x extends bl
{
  public x(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "UploadPackageAndPage";
  }

  public void b(ITreeNode paramITreeNode)
  {
    String str = StringUtil.replaceAll(this.a.getConfigManager().H(), "readrule", "deployrule");
    Object localObject;
    if ((paramITreeNode instanceof IRuleGroup))
    {
      localObject = (IRuleGroup)paramITreeNode;
      Iterator localIterator = ((IRuleGroup)paramITreeNode).getAcceptElements(new y(this));
      while (localIterator.hasNext())
      {
        IRulePackage localIRulePackage = (IRulePackage)localIterator.next();
        if (localIRulePackage.getRuletypeid() != 5)
          continue;
        this.a.getRulesManager().l().a(localIRulePackage, str, true);
      }
    }
    else if ((paramITreeNode instanceof IRulePackage))
    {
      localObject = (IRulePackage)paramITreeNode;
      if (((IRulePackage)localObject).getRuletypeid() == 5)
        this.a.getRulesManager().l().a((IRulePackage)localObject, str, true);
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    if ((!StringUtil.isEmpty(this.a.getConfigManager().H())) && (this.a.getConfigManager().H().indexOf("readrule") > 0))
    {
      if ((paramITreeNode instanceof IRuleGroup))
      {
        Iterator localIterator = ((IRuleGroup)paramITreeNode).getAcceptElements(new z(this));
        return localIterator.hasNext();
      }
      if ((paramITreeNode instanceof IRulePackage))
        return ((IRulePackage)paramITreeNode).getRuletypeid() == 5;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.x
 * JD-Core Version:    0.6.0
 */