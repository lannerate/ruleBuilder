package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.v;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;

public class b extends x
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if (((paramITreeNode instanceof RulePackage)) && (((RulePackage)paramITreeNode).getProject() != null))
    {
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      String str1 = localRulePackage.getProject().getDisplayName();
      String str2 = localRulePackage.getProject().getProjver();
      String str3 = localRulePackage.getProject().getDocument();
      v localv = new v(this.a, str1, str2, str3);
      if (localv.open() == 0)
      {
        a((RulePackage)paramITreeNode, true, localv.a(), localv.b());
        if (localv.a() > 0)
        {
          ((RulePackage)paramITreeNode).setProjver(localv.c());
          try
          {
            ((RulePackage)paramITreeNode).selfSave();
          }
          catch (Exception localException)
          {
          }
        }
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RulePackage;
  }

  protected boolean d()
  {
    return false;
  }

  public String a()
  {
    return "CheckInVersion";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.b
 * JD-Core Version:    0.6.0
 */