package com.flagleader.builder.actions.j.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.j.x;
import com.flagleader.manager.a.a.a;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;

public class b extends x
{
  public b(BuilderManager paramBuilderManager)
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
    b((RulePackage)paramITreeNode, false);
  }

  public String a()
  {
    return "SaveDB";
  }

  public void b(RulePackage paramRulePackage, boolean paramBoolean)
  {
    if (paramRulePackage.isLocked())
    {
      this.a.showError(c.b("locked.updatedb"));
      return;
    }
    if (!this.a.getRulesManager().w())
    {
      this.a.showError(c.b("locked.updatedb"));
      return;
    }
    this.a.getRulesManager().u().a(paramRulePackage, paramBoolean, 0, "", false);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.a.b
 * JD-Core Version:    0.6.0
 */