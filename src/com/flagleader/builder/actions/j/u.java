package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.D;
import com.flagleader.manager.a.a.j;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;

public class u extends x
{
  public u(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleTree;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof IRuleTree))
      return;
    if (!e())
      return;
    String str1 = "";
    String str2 = "";
    if ((paramITreeNode.getParent() instanceof IRuleTree))
      str1 = paramITreeNode.getParent().toString();
    if (((IRuleTree)paramITreeNode).getMainPackage() != null)
      str2 = ((IRuleTree)paramITreeNode).getMainPackage().getTemplateType();
    D localD = new D(this.a, str1, str2);
    if (localD.open() == 0)
      this.a.getRulesManager().r().a((IRuleTree)paramITreeNode, true, localD.a(), localD.b());
  }

  public String a()
  {
    return "TemplateRuleUpdate";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.u
 * JD-Core Version:    0.6.0
 */