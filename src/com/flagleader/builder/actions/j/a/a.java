package com.flagleader.builder.actions.j.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.j.x;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;

public class a extends x
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RulePackage;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (!(paramITreeNode instanceof RulePackage)))
      return;
    RulePackage localRulePackage = (RulePackage)paramITreeNode;
    if (localRulePackage.isLocked())
    {
      this.a.showError(c.b("locked.updatedb"));
      return;
    }
    this.a.getRulesManager().u().a(localRulePackage, true, 0, "", false);
  }

  public String a()
  {
    return "NewDBRules";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.a.a
 * JD-Core Version:    0.6.0
 */