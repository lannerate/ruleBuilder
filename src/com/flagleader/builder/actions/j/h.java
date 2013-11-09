package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.j;
import com.flagleader.builder.dialogs.g.v;
import com.flagleader.manager.a.a.g;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
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

public class h extends x
{
  public h(BuilderManager paramBuilderManager)
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
        j localj = new j(this.a, localIRuleGroup.getProject(), localv.a());
        if (localj.open() == 0)
        {
          if (localIRuleGroup.getProject().getDisplayName().equals(localv.b()))
          {
            localIRuleGroup.getProject().setProjver(localv.c());
            localIRuleGroup.getProject().setDocument(localv.d());
          }
          this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
          List localList = localj.b();
          for (int i = 0; i < localList.size(); i++)
          {
            RulePackage localRulePackage1 = localIRuleGroup.exitsPackage(((List)localList.get(i)).get(2).toString());
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
              if (((localIRuleGroup instanceof RuleProject)) && (localg.h().length() > 0))
                ((RuleProject)localIRuleGroup).addGroupPackage(localRulePackage2, localg.h());
              else
                localIRuleGroup.addChildElement(localRulePackage2);
              if (localv.a() > 0)
                localRulePackage2.setProjver(str2);
              localRulePackage2.setNeedSave(true);
              this.a.getUserLogger().c(c.a("success.loadDB", new String[] { localRulePackage2.toString() + " : " }));
            }
            catch (Exception localException)
            {
              this.a.showError(localException.getMessage());
              return;
            }
          }
          if (localList.size() > 0)
          {
            localIRuleGroup.setModified(true);
            localIRuleGroup.updateTree();
          }
          this.a.getShell().setCursor(null);
        }
      }
    }
  }

  public String a()
  {
    return "LoadRuleProjver";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.h
 * JD-Core Version:    0.6.0
 */