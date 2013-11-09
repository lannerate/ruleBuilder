package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.m;
import com.flagleader.manager.a.a.g;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class j extends x
{
  public j(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return;
    if (!e())
      return;
    if ((paramITreeNode instanceof RulePackage))
      a((RulePackage)paramITreeNode);
    else if ((paramITreeNode instanceof IRuleGroup))
      a((IRuleGroup)paramITreeNode);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return true;
  }

  public String a()
  {
    return "LoadVersion";
  }

  private void a(IRuleGroup paramIRuleGroup)
  {
    com.flagleader.builder.dialogs.g.j localj = new com.flagleader.builder.dialogs.g.j(this.a, paramIRuleGroup.getProject(), 0);
    if (localj.open() == 0)
    {
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      List localList = localj.b();
      for (int i = 0; i < localList.size(); i++)
      {
        RulePackage localRulePackage1 = paramIRuleGroup.exitsPackage(((List)localList.get(i)).get(2).toString());
        if (localRulePackage1 != null)
        {
          if (!this.a.showQuestion(c.b("importPackError.importpackage")))
            continue;
          localRulePackage1.disposeAndUpdate();
        }
        try
        {
          g localg = this.a.getRulesManager().e();
          if (!localg.a(NumberUtil.getInt(StringUtil.stringValue(((List)localList.get(i)).get(0))), ((List)localList.get(i)).get(8).toString(), ((List)localList.get(i)).get(2).toString()))
            continue;
          RulePackage localRulePackage2 = localg.d();
          if (localRulePackage2 == null)
            return;
          if (((paramIRuleGroup instanceof RuleProject)) && (((List)localList.get(i)).size() > 9))
            ((RuleProject)paramIRuleGroup).addGroupPackage(localRulePackage2, ((List)localList.get(i)).get(9).toString());
          else
            paramIRuleGroup.addChildElement(localRulePackage2);
          paramIRuleGroup.setModified(true);
          paramIRuleGroup.updateTree();
        }
        catch (Exception localException)
        {
          this.a.showError(localException.getMessage());
          return;
        }
      }
      if (localList.size() > 0)
      {
        paramIRuleGroup.setModified(true);
        paramIRuleGroup.updateTree();
      }
      this.a.getShell().setCursor(null);
    }
  }

  private void a(RulePackage paramRulePackage)
  {
    if ((paramRulePackage.getProject() != null) && (paramRulePackage.getProject().isLocked()))
    {
      this.a.showError(c.b("lockproject.checkout"));
      return;
    }
    m localm = new m(this.a, paramRulePackage.getExeRulePackageName(), paramRulePackage.getRulesid());
    if (localm.open() == 0)
    {
      List localList = localm.c();
      if (localList.size() > 0)
        try
        {
          g localg = this.a.getRulesManager().e();
          if (localg.a(NumberUtil.getInt(StringUtil.stringValue(((List)localList.get(0)).get(3))), ((List)localList.get(0)).get(1).toString(), paramRulePackage.getExeRulePackageName()))
          {
            paramRulePackage = localg.a(paramRulePackage);
            if (paramRulePackage.getProject() != null)
              paramRulePackage.getProject().setNeedSave(true);
            paramRulePackage.disposeAllViewer();
            paramRulePackage.updateTree();
            this.a.getUserLogger().c(c.a("success.loadDB", new String[] { paramRulePackage.getDisplayName() }));
          }
        }
        catch (Exception localException)
        {
          this.a.showError(localException.getMessage());
        }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.j
 * JD-Core Version:    0.6.0
 */