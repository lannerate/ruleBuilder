package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.A;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.List;

public class v extends x
{
  public v(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    String str;
    if ((paramITreeNode instanceof RulePackage))
    {
      str = "";
      if (((RulePackage)paramITreeNode).getProject() != null)
        str = ((RulePackage)paramITreeNode).getProject().getDisplayName();
      b((RulePackage)paramITreeNode);
    }
    else if ((paramITreeNode instanceof IRuleGroup))
    {
      str = "";
      if (((IRuleGroup)paramITreeNode).getProject() != null)
        str = ((IRuleGroup)paramITreeNode).getProject().getDisplayName();
      A localA = new A(this.a, (IRuleGroup)paramITreeNode, 0);
      if (localA.open() == 0)
      {
        List localList = localA.a();
        for (int i = 0; i < localList.size(); i++)
          b((RulePackage)localList.get(i));
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return (((paramITreeNode instanceof RulePackage)) && (!((RulePackage)paramITreeNode).isLockCheckOut())) || ((paramITreeNode instanceof IRuleGroup));
  }

  protected boolean d()
  {
    return false;
  }

  public String a()
  {
    return "unlockcheckout";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.v
 * JD-Core Version:    0.6.0
 */