package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.v;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleDBProject;

public class m extends x
{
  public m(BuilderManager paramBuilderManager)
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
    String str = "";
    if ((paramITreeNode != null) && ((paramITreeNode instanceof RuleDBProject)))
      str = paramITreeNode.getDisplayName();
    v localv = new v(str, this.a.getShell());
    if (localv.open() == 0)
    {
      str = localv.a();
      this.a.getRulesManager().a(str);
    }
  }

  public String a()
  {
    return "NewServerPackageItem";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.m
 * JD-Core Version:    0.6.0
 */