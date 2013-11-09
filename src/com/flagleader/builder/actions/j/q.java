package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.A;
import com.flagleader.builder.dialogs.g.v;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class q extends x
{
  public q(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleGroup;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if (((paramITreeNode instanceof IRuleGroup)) && (((IRuleGroup)paramITreeNode).getProject() != null))
    {
      IRuleGroup localIRuleGroup = (IRuleGroup)paramITreeNode;
      String str1 = localIRuleGroup.getProject().getDisplayName();
      String str2 = localIRuleGroup.getProject().getProjver();
      String str3 = localIRuleGroup.getProject().getDocument();
      v localv = new v(this.a, str1, str2, str3);
      if (localv.open() == 0)
      {
        A localA = new A(this.a, (IRuleGroup)paramITreeNode, localv.a());
        if (localA.open() == 0)
        {
          if (localIRuleGroup.getProject().getDisplayName().equals(localv.b()))
          {
            localIRuleGroup.getProject().setProjver(localv.c());
            localIRuleGroup.getProject().setDocument(localv.d());
          }
          this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
          List localList = localA.a();
          a(localA.a(), true, localv.a(), localv.b());
          for (int i = 0; i < localList.size(); i++)
          {
            RulePackage localRulePackage = (RulePackage)localList.get(i);
            if (localv.a() <= 0)
              continue;
            localRulePackage.setProjver(localv.c());
            try
            {
              localRulePackage.selfSave();
            }
            catch (Exception localException)
            {
            }
          }
          this.a.getShell().setCursor(null);
        }
      }
    }
  }

  public String a()
  {
    return "SaveRuleProjver";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.q
 * JD-Core Version:    0.6.0
 */